package com.prlsnraju.weatherapp.network;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class CityApiService {

    public static final String BASE_URL = "http://api.openweathermap.org/";
    public static final String API_KEY = "15b015e37826d189ace6b108da529d7c";

    public static final CityAPI retrofit = RetrofitClient.createService(CityAPI.class);

}

