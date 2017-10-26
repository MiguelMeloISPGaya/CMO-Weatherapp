package models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ForecastResult {

    @SerializedName("dt")
    private Long timestamp_of_forecast;
    @SerializedName("main")
    private Main_Temps temps;
    @SerializedName("weather")
    private List<WeatherResult> weatherResultList = new ArrayList<>();
    @SerializedName("clouds")
    private CloudsResult clouds;
    @SerializedName("wind")
    private WindResult windResult;
    @SerializedName("rain")
    private RainResult rainResult;
    @SerializedName("snow")
    private SnowResult snowresult;
    @SerializedName("sys")
    private SysResult sys;
    @SerializedName("dt_txt")
    private String date_of_forecast;

    public ForecastResult() {
    }

    public ForecastResult(Long timestamp_of_forecast, Main_Temps temps, List<WeatherResult> weatherResultList, CloudsResult clouds, WindResult windResult, RainResult rainResult, SnowResult snowresult, SysResult sys, String date_of_forecast) {
        this.timestamp_of_forecast = timestamp_of_forecast;
        this.temps = temps;
        this.weatherResultList = weatherResultList;
        this.clouds = clouds;
        this.windResult = windResult;
        this.rainResult = rainResult;
        this.snowresult = snowresult;
        this.sys = sys;
        this.date_of_forecast = date_of_forecast;
    }

    public Long getTimestamp_of_forecast() {
        return timestamp_of_forecast;
    }

    public void setTimestamp_of_forecast(Long timestamp_of_forecast) {
        this.timestamp_of_forecast = timestamp_of_forecast;
    }

    public Main_Temps getTemps() {
        return temps;
    }

    public void setTemps(Main_Temps temps) {
        this.temps = temps;
    }

    public List<WeatherResult> getWeatherResultList() {
        return weatherResultList;
    }

    public void setWeatherResultList(List<WeatherResult> weatherResultList) {
        this.weatherResultList = weatherResultList;
    }

    public CloudsResult getClouds() {
        return clouds;
    }

    public void setClouds(CloudsResult clouds) {
        this.clouds = clouds;
    }

    public WindResult getWindResult() {
        return windResult;
    }

    public void setWindResult(WindResult windResult) {
        this.windResult = windResult;
    }

    public RainResult getRainResult() {
        return rainResult;
    }

    public void setRainResult(RainResult rainResult) {
        this.rainResult = rainResult;
    }

    public SnowResult getSnowresult() {
        return snowresult;
    }

    public void setSnowresult(SnowResult snowresult) {
        this.snowresult = snowresult;
    }

    public SysResult getSys() {
        return sys;
    }

    public void setSys(SysResult sys) {
        this.sys = sys;
    }

    public String getDate_of_forecast() {
        return date_of_forecast;
    }

    public void setDate_of_forecast(String date_of_forecast) {
        this.date_of_forecast = date_of_forecast;
    }
}
