package pt.ispg3814.com.weatherapp;

import android.app.Application;

import models.Weather;
import utils.NetworkstatusReceiver;

public class Weatherapp extends Application {
    private static Weatherapp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public static synchronized Weatherapp getInstance() {
        return mInstance;
    }

    public void setConnectionListener(NetworkstatusReceiver.NetworkstatusReceiverListener listener) {
        NetworkstatusReceiver.nsrl = listener;
    }
}
