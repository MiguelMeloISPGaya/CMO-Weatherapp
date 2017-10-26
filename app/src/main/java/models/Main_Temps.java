package models;

import com.google.gson.annotations.SerializedName;

public class Main_Temps {

    @SerializedName("temp")
    private double temperature;
    @SerializedName("temp_min")
    private double minimum_temperature;
    @SerializedName("temp_max")
    private double maximum_temperature;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("sea_level")
    private double sea_level;
    @SerializedName("grnd_level")
    private double ground_level;
    @SerializedName("humidity")
    private int humidity;
    @SerializedName("temp_kf")
    private double temp_kf;

    public Main_Temps() {

    }

    public Main_Temps(double temperature, double minimum_temperature, double maximum_temperature, double pressure, double sea_level, double ground_level, int humidity, double temp_kf) {
        this.temperature = temperature;
        this.minimum_temperature = minimum_temperature;
        this.maximum_temperature = maximum_temperature;
        this.pressure = pressure;
        this.sea_level = sea_level;
        this.ground_level = ground_level;
        this.humidity = humidity;
        this.temp_kf = temp_kf;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getMinimum_temperature() {
        return minimum_temperature;
    }

    public void setMinimum_temperature(double minimum_temperature) {
        this.minimum_temperature = minimum_temperature;
    }

    public double getMaximum_temperature() {
        return maximum_temperature;
    }

    public void setMaximum_temperature(double maximum_temperature) {
        this.maximum_temperature = maximum_temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSea_level() {
        return sea_level;
    }

    public void setSea_level(double sea_level) {
        this.sea_level = sea_level;
    }

    public double getGround_level() {
        return ground_level;
    }

    public void setGround_level(double ground_level) {
        this.ground_level = ground_level;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(double temp_kf) {
        this.temp_kf = temp_kf;
    }

}
