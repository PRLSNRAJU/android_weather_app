package com.prlsnraju.weatherapp.network;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {

    public static final WeatherApiService weatherConnection = RetrofitClient.createService(WeatherApiService.class);

    @GET("data/2.5/weather")
    public Call<WeatherPojo> getWeather(@Query("lat") String latitude, @Query("lon") String longitude, @Query("appid") String apiKey, @Query("units") String unit);

}

