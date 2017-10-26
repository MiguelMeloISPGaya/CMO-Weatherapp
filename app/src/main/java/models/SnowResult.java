package models;

import com.google.gson.annotations.SerializedName;

class SnowResult {

    @SerializedName("3h")
    private double snow_volume_3hours;

    public SnowResult() {
    }

    public SnowResult(double snow_volume_3hours) {
        this.snow_volume_3hours = snow_volume_3hours;
    }

    public double getSnow_volume_3hours() {
        return snow_volume_3hours;
    }

    public void setSnow_volume_3hours(double snow_volume_3hours) {
        this.snow_volume_3hours = snow_volume_3hours;
    }
}
