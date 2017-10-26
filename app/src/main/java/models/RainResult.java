package models;

import com.google.gson.annotations.SerializedName;

class RainResult {

    @SerializedName("3h")
    private double rain_volume_3hours;

    public RainResult() {
    }

    public RainResult(double rain_volume_3hours) {
        this.rain_volume_3hours = rain_volume_3hours;
    }

    public double getRain_volume_3hours() {
        return rain_volume_3hours;
    }

    public void setRain_volume_3hours(double rain_volume_3hours) {
        this.rain_volume_3hours = rain_volume_3hours;
    }
}
