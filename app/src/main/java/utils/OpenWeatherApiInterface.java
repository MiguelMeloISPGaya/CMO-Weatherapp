package utils;

import models.ForecastResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface OpenWeatherApiInterface {

    @GET("forecast")
    Call<ForecastResponse> getForecastForCity(@Query("q") String query, @Query("lang") String language_code, @Query("appid") String apiKey);

    @GET("forecast")
    Call<ForecastResponse> getForecastForCity(@Query("q") String query, @Query("lang") String language_code, @Query("units") String units, @Query("appid") String apiKey);
}


//q=Porto, PT&lang=pt&appid=b46a61e29dbbb32035b71656573d5697
