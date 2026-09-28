package com.heatgrid.api.repository;

import com.heatgrid.api.entity.HeatZone;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatZoneRepository extends JpaRepository<HeatZone, Long> {
    List<HeatZone> findByCityId(Long cityId);

    List<HeatZone> findByCityIdAndRiskLevelIgnoreCase(Long cityId, String riskLevel);
}
