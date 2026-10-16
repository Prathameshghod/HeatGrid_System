package com.heatgrid.api;

import com.heatgrid.api.dto.HeatZoneBatchRequest;
import com.heatgrid.api.entity.City;
import com.heatgrid.api.entity.HeatZone;
import com.heatgrid.api.service.CityService;
import com.heatgrid.api.service.HeatZoneService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/heat-zones")
public class HeatZoneController {
    private final HeatZoneService heatZones;
    private final CityService cities;
    public HeatZoneController(HeatZoneService heatZones, CityService cities) {
        this.heatZones = heatZones;
        this.cities = cities;
    }

    @GetMapping
    public List<HeatZone> find(@RequestParam(required = false) Long cityId) {
        return cityId == null ? heatZones.findAll() : heatZones.findByCity(cityId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HeatZone create(@RequestParam Long cityId, @RequestBody HeatZone zone) {
        return heatZones.save(zone, cities.findById(cityId));
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public List<HeatZone> createBatch(@RequestBody HeatZoneBatchRequest request) {
        City city = cities.findById(request.cityId());
        return heatZones.saveAll(request.zones(), city);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { heatZones.delete(id); }
}
