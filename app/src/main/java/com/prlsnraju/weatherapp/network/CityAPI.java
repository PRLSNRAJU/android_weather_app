package com.prlsnraju.weatherapp.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CityAPI {

    @GET("/geo/1.0/direct")
    public Call<List<City>> getCoordinates(@Query("q") String cityName, @Query("limit") int limit, @Query("appid") String apiKey);
}
