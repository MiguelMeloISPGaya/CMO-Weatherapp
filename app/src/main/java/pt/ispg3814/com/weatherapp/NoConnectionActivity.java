package pt.ispg3814.com.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import utils.NetworkstatusReceiver;

public class NoConnectionActivity extends AppCompatActivity implements NetworkstatusReceiver.NetworkstatusReceiverListener {

    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_connection);
        NoConnectionActivity.setmContext(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean connected) {
        if(connected){
            Intent intent = new Intent(NoConnectionActivity.getmContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            NoConnectionActivity.getmContext().startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // when we resume the app, we need to register the listener again
        Weatherapp.getInstance().setConnectionListener(this);
    }

    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context mContext) {
        NoConnectionActivity.mContext = mContext;
    }
}
