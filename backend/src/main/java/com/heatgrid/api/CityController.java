package com.heatgrid.api;

import com.heatgrid.api.entity.City;
import com.heatgrid.api.service.CityService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getCities(@RequestParam(required = false) String search) {
        if (search == null || search.isBlank()) {
            return cityService.getAllCities();
        }
        return cityService.searchCities(search);
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }
}
