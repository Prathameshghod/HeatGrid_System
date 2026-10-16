package com.heatgrid.api.dto;

import com.heatgrid.api.entity.HeatZone;
import java.util.List;

public record HeatZoneBatchRequest(Long cityId, List<HeatZone> zones) {
    public HeatZoneBatchRequest {
        if (cityId == null) throw new IllegalArgumentException("cityId is required");
        if (zones == null || zones.isEmpty()) throw new IllegalArgumentException("zones must not be empty");
    }
}
