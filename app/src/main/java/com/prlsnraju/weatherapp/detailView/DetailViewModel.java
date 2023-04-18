package com.prlsnraju.weatherapp.detailView;

import static com.prlsnraju.weatherapp.network.WeatherApiService.weatherConnection;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.prlsnraju.weatherapp.network.RetrofitClient;
import com.prlsnraju.weatherapp.network.WeatherPojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailViewModel extends ViewModel {

    private MutableLiveData<String> _imageUrl = new MutableLiveData<>();
    public LiveData<String> imageUrl = _imageUrl;

    private long timeZone;
    private MutableLiveData<Long> _dateTime = new MutableLiveData<>();
    public LiveData<String> dateTime = Transformations.map(_dateTime, new Function<Long, String>() {
        @Override
        public String apply(Long input) {
            long city = (input * 1000) + timeZone;
            Date upda = new Date(city);
            return upda.toString();
        }
    });

    private MutableLiveData<String> _city_country = new MutableLiveData<>();
    public LiveData<String> city_country = _city_country;

    private MutableLiveData<Float> _temp = new MutableLiveData<>();
    public LiveData<String> temp = Transformations.map(_temp, input -> {
        return String.valueOf(input*9/5+32);
    });

    private MutableLiveData<String> _warning = new MutableLiveData<>();
    public LiveData<String> warning = _warning;

    private MutableLiveData<String> _description = new MutableLiveData<>();
    public LiveData<String> description = _description;

    private MutableLiveData<Integer> _pressure = new MutableLiveData<>();
    public LiveData<String> pressure = Transformations.map(_pressure, input -> "Pressure: " + input+"hPa");

    private MutableLiveData<Integer> _humidity = new MutableLiveData<>();
    public LiveData<String> humidity = Transformations.map(_humidity, input -> "Humidity: " + String.valueOf(_humidity));

    private MutableLiveData<String> _dew_point = new MutableLiveData<>();
    public LiveData<String> dew_point = Transformations.map(_dew_point, input -> "Dew point: " + _dew_point);

    private MutableLiveData<Double> _wind = new MutableLiveData<>();
    public LiveData<String> wind = Transformations.map(_wind, input -> "Wind speed: " + String.valueOf(input));

    private MutableLiveData<String> _uv = new MutableLiveData<>();
    public LiveData<String> uv = _uv;

    private MutableLiveData<String> _visibility = new MutableLiveData<>();
    public LiveData<String> visibility = Transformations.map(_visibility, input -> "Visibility: "+ input + "m");
    
    public void execute(String lon, String lat) {
        Call<WeatherPojo> weatherReq = weatherConnection.getWeather(lat, lon, RetrofitClient.API_KEY, "metric");
        weatherReq.enqueue(new Callback<WeatherPojo>() {
            @Override
            public void onResponse(Call<WeatherPojo> call, Response<WeatherPojo> response) {
                WeatherPojo weather = response.body();
                _visibility.setValue(String.valueOf(weather.getVisibility()));
                _humidity.setValue(weather.getMain().getHumidity());
                _wind.setValue(weather.getWind().getSpeed());
//                _dew_point.setValue(weather.get);
                _pressure.setValue(weather.getMain().getPressure());
                timeZone = weather.getTimezone();
                _dateTime.setValue(weather.getDt());
                _temp.setValue(weather.getMain().getTemp());
                _imageUrl.setValue("https://openweathermap.org/img/wn/"+ weather.getWeather().get(0).getIcon() +"@2x.png");

            }

            @Override
            public void onFailure(Call<WeatherPojo> call, Throwable t) {

            }
        });
    }
    // TODO: Implement the ViewModel
}