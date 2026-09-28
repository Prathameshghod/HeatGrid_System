package com.heatgrid.api.service;

import com.heatgrid.api.entity.City;
import com.heatgrid.api.repository.CityRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + id));
    }

    public List<City> searchCities(String cityName) {
        return cityRepository.findByCityNameContainingIgnoreCase(cityName);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }
}
