package com.prlsnraju.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.prlsnraju.weatherapp.network.City;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> _CityName = new MutableLiveData<>();
    public LiveData<String> cityName = _CityName;

    public void onSearchBtnClick(){
        _CityName.setValue("");
    }

    public void setCityName(String name){

    }
}
