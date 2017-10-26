package models;

import com.google.gson.annotations.SerializedName;

public class WeatherResult {

    @SerializedName("id")
    private int id;
    @SerializedName("main")
    private String main_params;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public WeatherResult() {
    }

    public WeatherResult(int id, String main_params, String description, String icon) {
        this.id = id;
        this.main_params = main_params;
        this.description = description;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain_params() {
        return main_params;
    }

    public void setMain_params(String main_params) {
        this.main_params = main_params;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
