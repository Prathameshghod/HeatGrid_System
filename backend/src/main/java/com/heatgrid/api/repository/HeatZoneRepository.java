package com.heatgrid.api.repository;

import com.heatgrid.api.entity.HeatZone;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeatZoneRepository extends JpaRepository<HeatZone, Long> {
    List<HeatZone> findByCityId(Long cityId);
}
