package com.prlsnraju.weatherapp;

import static com.prlsnraju.weatherapp.network.CityApiService.API_KEY;
import static com.prlsnraju.weatherapp.network.CityApiService.retrofit;
import static com.prlsnraju.weatherapp.network.WeatherApiService.weatherConnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.prlsnraju.weatherapp.databinding.ActivityMainBinding;
import com.prlsnraju.weatherapp.network.City;
import com.prlsnraju.weatherapp.network.Main;
import com.prlsnraju.weatherapp.network.RetrofitClient;
import com.prlsnraju.weatherapp.network.WeatherApiService;
import com.prlsnraju.weatherapp.network.WeatherPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        NavController controller = Navigation.findNavController(this, R.id.nav_host_fragment);

        binding.searchBtn.setOnClickListener(it -> {
            String text = binding.searchEt.getText().toString();
            Bundle b = new Bundle();
            b.putString("Location", text);
            controller.navigate(R.id.overviewFragment, b);
        });
    }
}