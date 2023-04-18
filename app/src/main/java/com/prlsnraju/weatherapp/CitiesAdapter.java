package com.prlsnraju.weatherapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.prlsnraju.weatherapp.databinding.ItemCityBinding;
import com.prlsnraju.weatherapp.network.City;

import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder> {

    List<City> cities = null;
    OnClickListener listener;


    public CitiesAdapter(OnClickListener clickListener){
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public CitiesAdapter.CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemCityBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_city, parent, false);
        return new CitiesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesAdapter.CitiesViewHolder holder, int position) {

        if(cities == null) return;

        City city = cities.get(position);
        holder.itemView.setOnClickListener( it ->{
            this.listener.onClick(city);
        });
        holder.bind(city);

    }

    @Override
    public int getItemCount() {
        return cities == null ? 0 : cities.size();
    }

    public class CitiesViewHolder extends RecyclerView.ViewHolder {

        ItemCityBinding binding;
        public CitiesViewHolder(@NonNull ItemCityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(City city) {
            binding.setCity(city);
            binding.executePendingBindings();
        }
    }

    public interface OnClickListener{
        public void onClick(City city);
    }

}
