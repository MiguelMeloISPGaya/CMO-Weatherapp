package models;

/**
 * Created by Blacknemesist on 26/10/2017.
 */

public class GooglePlacesResult {
    private String city, country;

    public GooglePlacesResult() {
    }

    public GooglePlacesResult(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
