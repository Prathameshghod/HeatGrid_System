package com.heatgrid.api.repository;

import com.heatgrid.api.entity.Intervention;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {
    List<Intervention> findByCityId(Long cityId);

    List<Intervention> findByHeatZoneId(Long heatZoneId);

    List<Intervention> findByCityIdAndPriorityIgnoreCase(Long cityId, String priority);
}
