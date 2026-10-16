package com.heatgrid.api;

import com.heatgrid.api.entity.HeatZone;
import com.heatgrid.api.entity.Intervention;
import com.heatgrid.api.service.CityService;
import com.heatgrid.api.service.HeatZoneService;
import com.heatgrid.api.service.InterventionService;
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
@RequestMapping("/api/interventions")
public class InterventionController {
    private final InterventionService interventions;
    private final CityService cities;
    private final HeatZoneService heatZones;
    public InterventionController(InterventionService interventions, CityService cities,
                                  HeatZoneService heatZones) {
        this.interventions = interventions;
        this.cities = cities;
        this.heatZones = heatZones;
    }

    @GetMapping
    public List<Intervention> find(@RequestParam(required = false) Long cityId,
                                   @RequestParam(required = false) Long heatZoneId) {
        if (heatZoneId != null) return interventions.findByHeatZone(heatZoneId);
        if (cityId != null) return interventions.findByCity(cityId);
        throw new IllegalArgumentException("Provide cityId or heatZoneId");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Intervention create(@RequestParam Long cityId,
                               @RequestParam(required = false) Long heatZoneId,
                               @RequestBody Intervention intervention) {
        HeatZone zone = heatZoneId == null ? null : heatZones.findByCity(cities.findById(cityId).getId())
                .stream().filter(item -> item.getId().equals(heatZoneId)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Heat zone does not belong to city"));
        return interventions.save(intervention, cities.findById(cityId), zone);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { interventions.delete(id); }
}
