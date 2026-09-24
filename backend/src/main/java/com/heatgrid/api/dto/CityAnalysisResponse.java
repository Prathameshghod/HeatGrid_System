package com.heatgrid.api.dto;

import java.util.List;

public record CityAnalysisResponse(
        String city,
        int heatScore,
        String riskBand,
        List<String> drivers,
        List<String> interventions) {
}
