package com.heatgrid.api;

import com.heatgrid.api.entity.City;
import com.heatgrid.api.service.CityService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private final CityService cities;
    public CityController(CityService cities) { this.cities = cities; }

    @GetMapping
    public List<City> findAll() { return cities.findAll(); }

    @GetMapping("/{id}")
    public City findById(@PathVariable Long id) { return cities.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City create(@RequestBody City city) { return cities.save(city); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { cities.delete(id); }
}
