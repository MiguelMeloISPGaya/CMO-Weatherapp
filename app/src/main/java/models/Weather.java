package models;

public class Weather {

    private int id;
    private String main_params,description,icon;

    public Weather() {

    }

    public Weather(String main_params, String description, String icon) {
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
