package com.prlsnraju.weatherapp.citiesView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prlsnraju.weatherapp.CitiesAdapter;
import com.prlsnraju.weatherapp.databinding.FragmentOverviewBinding;
import com.prlsnraju.weatherapp.network.City;

import java.util.ArrayList;
import java.util.List;

public class OverviewFragment extends Fragment {

    private OverviewViewModel mViewModel;
    private final List<City> cities = new ArrayList<>();
    private RecyclerView citiesView;

    public static OverviewFragment newInstance() {
        return new OverviewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        FragmentOverviewBinding binding = FragmentOverviewBinding.inflate(inflater);
        OverviewViewModel viewModel = new ViewModelProvider(this).get(OverviewViewModel.class);

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        binding.citiesRecyclerView.setAdapter(new CitiesAdapter(
                viewModel::updateCity));

        viewModel.selectedCity.observe(getViewLifecycleOwner(), city -> {
            navigateToDetail(city, binding.getRoot());
        });

        if(getArguments() != null){
            String location = getArguments().getString("Location");
            viewModel.requestCities(location);
        }

        return binding.getRoot();
    }

    private void navigateToDetail(City city, View view) {
        Navigation.findNavController(view)
                .navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(city.getLon().toString(), city.getLat().toString()));
    }

}