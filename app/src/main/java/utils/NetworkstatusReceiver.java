package utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import pt.ispg3814.com.weatherapp.Weatherapp;

public class NetworkstatusReceiver extends BroadcastReceiver {

    public static NetworkstatusReceiverListener nsrl;

    public NetworkstatusReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            NetworkInfo networkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                nsrl.onNetworkConnectionChanged(true);
            } else if (networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) {
                nsrl.onNetworkConnectionChanged(false);
            }
        }
    }

    public static boolean connected() {
        ConnectivityManager cm = (ConnectivityManager) Weatherapp.getInstance().getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public interface NetworkstatusReceiverListener{
        void onNetworkConnectionChanged(boolean connected);
    }
}
