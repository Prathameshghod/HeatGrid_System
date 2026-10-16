package com.heatgrid.api.service;

import com.heatgrid.api.entity.City;
import com.heatgrid.api.repository.CityRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CityService {
    private final CityRepository cities;

    public CityService(CityRepository cities) { this.cities = cities; }

    public List<City> findAll() { return cities.findAll(); }

    public City findById(Long id) {
        return cities.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", id));
    }

    @Transactional
    public City save(City city) { return cities.save(city); }

    @Transactional
    public void delete(Long id) {
        if (!cities.existsById(id)) throw new ResourceNotFoundException("City", id);
        cities.deleteById(id);
    }
}
