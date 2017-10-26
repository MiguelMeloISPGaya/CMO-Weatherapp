package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastResponse {

    @SerializedName("cod")
    private String response_code;
    @SerializedName("message")
    private double internal_msg_code;
    @SerializedName("cnt")
    private int result_count;
    @SerializedName("list")
    private List<ForecastResult> forecastresult;
    @SerializedName("city")
    private CityResult cityResult;

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public double getInternal_msg_code() {
        return internal_msg_code;
    }

    public void setInternal_msg_code(double internal_msg_code) {
        this.internal_msg_code = internal_msg_code;
    }

    public int getResult_count() {
        return result_count;
    }

    public void setResult_count(int result_count) {
        this.result_count = result_count;
    }

    public List<ForecastResult> getForecastresult() {
        return forecastresult;
    }

    public void setForecastresult(List<ForecastResult> forecastresult) {
        this.forecastresult = forecastresult;
    }

    public CityResult getCityResult() {
        return cityResult;
    }

    public void setCityResult(CityResult cityResult) {
        this.cityResult = cityResult;
    }
}
