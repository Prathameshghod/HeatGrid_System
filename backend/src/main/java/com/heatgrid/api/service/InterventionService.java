package com.heatgrid.api.service;

import com.heatgrid.api.entity.City;
import com.heatgrid.api.entity.HeatZone;
import com.heatgrid.api.entity.Intervention;
import com.heatgrid.api.repository.InterventionRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class InterventionService {
    private final InterventionRepository interventions;

    public InterventionService(InterventionRepository interventions) { this.interventions = interventions; }

    public List<Intervention> findByCity(Long cityId) { return interventions.findByCityId(cityId); }
    public List<Intervention> findByHeatZone(Long heatZoneId) { return interventions.findByHeatZoneId(heatZoneId); }

    @Transactional
    public Intervention save(Intervention intervention, City city, HeatZone zone) {
        intervention.setCity(city);
        intervention.setHeatZone(zone);
        return interventions.save(intervention);
    }

    @Transactional
    public void delete(Long id) {
        if (!interventions.existsById(id)) throw new ResourceNotFoundException("Intervention", id);
        interventions.deleteById(id);
    }
}
