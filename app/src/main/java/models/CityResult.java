package models;

import com.google.gson.annotations.SerializedName;

public class CityResult{

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("coord")
    private Coordinates coords;
    @SerializedName("country")
    private String country_code;

    public CityResult() {
    }

    public CityResult(int id, String name, Coordinates coords, String country_code) {
        this.id = id;
        this.name = name;
        this.coords = coords;
        this.country_code = country_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoords() {
        return coords;
    }

    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    private class Coordinates {

            @SerializedName("lat")
            private double latitude;
            @SerializedName("log")
            private double longitude;

            public Coordinates() {
            }

            public Coordinates(double latitude, double longitude) {
                this.latitude = latitude;
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }
        }
}
