package com.prlsnraju.weatherapp;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.prlsnraju.weatherapp.network.City;

import java.util.List;

public class BindingAdapters {
    @BindingAdapter("displayName")
    public static void displayName(TextView view, City city){

        String name = "";

        if(city.getState() != null)
        {
            name = city.getState() + ", ";
        }

        name += city.getCountry();
        view.setText(name);
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter("listData")
    public static void bindRecyclerView(RecyclerView recyclerView, List<City> data) {
        CitiesAdapter adapter = (CitiesAdapter) recyclerView.getAdapter();
        if(adapter != null && data != null) {
            adapter.cities = data;
            adapter.notifyDataSetChanged();
        }
    }

    @BindingAdapter("loadImage")
    public static void loadImageUrl(ImageView iv, String url){
        Glide.with(iv.getContext()).load(url).into(iv);
    }
}
