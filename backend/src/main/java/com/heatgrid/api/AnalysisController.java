package com.heatgrid.api;

import com.heatgrid.api.dto.CityAnalysisResponse;
import com.heatgrid.api.service.AnalysisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnalysisController {
    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @GetMapping("/analysis/{city}")
    public CityAnalysisResponse analyze(@PathVariable String city) {
        return analysisService.analyze(city);
    }
}
