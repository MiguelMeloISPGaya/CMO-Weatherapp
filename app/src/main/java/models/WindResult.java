package models;

import com.google.gson.annotations.SerializedName;


class WindResult {

    @SerializedName("speed")
    private double speed;
    @SerializedName("deg")
    private double deg_direction;

    public WindResult() {

    }

    public WindResult(double speed, double deg_direction) {
        this.speed = speed;
        this.deg_direction = deg_direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg_direction() {
        return deg_direction;
    }

    public void setDeg_direction(double deg_direction) {
        this.deg_direction = deg_direction;
    }
}
