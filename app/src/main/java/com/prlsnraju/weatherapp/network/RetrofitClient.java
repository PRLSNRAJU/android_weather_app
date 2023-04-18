package com.prlsnraju.weatherapp.network;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String BASE_URL = "http://api.openweathermap.org/";
    public static final String API_KEY = "15b015e37826d189ace6b108da529d7c";

    private static final Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(BASE_URL)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();

    public static <T> T createService(Class<T> service){
        return retrofit.create(service);
    }
}
