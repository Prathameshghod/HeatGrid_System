package com.heatgrid.api.service;

import com.heatgrid.api.entity.City;
import com.heatgrid.api.entity.HeatZone;
import com.heatgrid.api.repository.HeatZoneRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class HeatZoneService {
    private final HeatZoneRepository heatZones;

    public HeatZoneService(HeatZoneRepository heatZones) { this.heatZones = heatZones; }

    public List<HeatZone> findAll() { return heatZones.findAll(); }
    public List<HeatZone> findByCity(Long cityId) { return heatZones.findByCityId(cityId); }

    @Transactional
    public HeatZone save(HeatZone zone, City city) {
        zone.setCity(city);
        return heatZones.save(zone);
    }

    @Transactional
    public List<HeatZone> saveAll(List<HeatZone> zones, City city) {
        zones.forEach(zone -> zone.setCity(city));
        return heatZones.saveAll(zones);
    }

    @Transactional
    public void delete(Long id) {
        if (!heatZones.existsById(id)) throw new ResourceNotFoundException("Heat zone", id);
        heatZones.deleteById(id);
    }
}
