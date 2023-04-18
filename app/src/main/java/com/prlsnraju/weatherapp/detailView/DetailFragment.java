package com.prlsnraju.weatherapp.detailView;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prlsnraju.weatherapp.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        DetailViewModel viewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        FragmentDetailBinding binding = FragmentDetailBinding.inflate(inflater);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        String lon = getArguments().getString("longitude");
        String lat = getArguments().getString("latitude");

        if (lon != null && lat != null) {
            viewModel.execute(lon, lat);
        }else{

        }

        return binding.getRoot();
    }

}