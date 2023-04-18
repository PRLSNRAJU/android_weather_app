package com.prlsnraju.weatherapp.citiesView;

import static com.prlsnraju.weatherapp.network.CityApiService.API_KEY;
import static com.prlsnraju.weatherapp.network.CityApiService.retrofit;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.prlsnraju.weatherapp.network.City;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OverviewViewModel extends ViewModel {

    private MutableLiveData<City> _selectedCity = new MutableLiveData<>();
    private MutableLiveData<List<City>> _cities = new MutableLiveData<>();

    public LiveData<City> selectedCity = _selectedCity;
    public LiveData<List<City>> cities = _cities;

    void requestCities(String location) {

        Call<List<City>> CitiesReq = retrofit.getCoordinates(location, 5, API_KEY);

        CitiesReq.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                List<City> Cities = response.body();
                if(cities != null){
                    _cities.setValue(Cities);
                }
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
                int j = 0;
            }
        });
    }

    public void updateCity(City city) {
        _selectedCity.setValue(city);
    }

    // TODO: Implement the ViewModel
}