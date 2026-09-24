package com.heatgrid.api.service;

import com.heatgrid.api.dto.CityAnalysisResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AnalysisService {
    public CityAnalysisResponse analyze(String city) {
        String normalized = city == null ? "" : city.trim();
        if (normalized.isEmpty()) {
            normalized = "Unknown city";
        }

        int heatScore = Math.min(100, Math.max(35, 48 + normalized.length() * 2));
        String riskBand = heatScore >= 75 ? "High" : heatScore >= 55 ? "Moderate" : "Watch";

        List<String> drivers = List.of(
                "Low canopy cover",
                "Dense built-up surfaces",
                "Limited night-time cooling");

        List<String> interventions = List.of(
                "Add shade trees along heat-exposed roads",
                "Target cool-roof retrofits for dense blocks",
                "Prioritize reflective paving near schools");

        return new CityAnalysisResponse(normalized, heatScore, riskBand, drivers, interventions);
    }
}
