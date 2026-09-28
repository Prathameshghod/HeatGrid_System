package com.heatgrid.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

// CRUD operations for the tables
@Entity
@Table(name = "heat_zones")
public class HeatZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "zone_name")
    private String zoneName;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "heat_score", precision = 8, scale = 4)
    private BigDecimal heatScore;

    @Column(name = "risk_level")
    private String riskLevel;

    @Column(name = "ndvi", precision = 8, scale = 5)
    private BigDecimal ndvi;

    @Column(name = "ndbi", precision = 8, scale = 5)
    private BigDecimal ndbi;

    @Column(name = "water_coverage", precision = 8, scale = 5)
    private BigDecimal waterCoverage;

    @Column(name = "elevation", precision = 10, scale = 2)
    private BigDecimal elevation;

    @Column(name = "ndvi_mean3", precision = 8, scale = 5)
    private BigDecimal ndviMean3;

    @Column(name = "ndbi_mean3", precision = 8, scale = 5)
    private BigDecimal ndbiMean3;

    @Column(name = "ndbi_mean5", precision = 8, scale = 5)
    private BigDecimal ndbiMean5;

    @Column(name = "ndbi_std3", precision = 8, scale = 5)
    private BigDecimal ndbiStd3;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public HeatZone() {
    }

    public Long getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getHeatScore() {
        return heatScore;
    }

    public void setHeatScore(BigDecimal heatScore) {
        this.heatScore = heatScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public BigDecimal getNdvi() {
        return ndvi;
    }

    public void setNdvi(BigDecimal ndvi) {
        this.ndvi = ndvi;
    }

    public BigDecimal getNdbi() {
        return ndbi;
    }

    public void setNdbi(BigDecimal ndbi) {
        this.ndbi = ndbi;
    }

    public BigDecimal getWaterCoverage() {
        return waterCoverage;
    }

    public void setWaterCoverage(BigDecimal waterCoverage) {
        this.waterCoverage = waterCoverage;
    }

    public BigDecimal getElevation() {
        return elevation;
    }

    public void setElevation(BigDecimal elevation) {
        this.elevation = elevation;
    }

    public BigDecimal getNdviMean3() {
        return ndviMean3;
    }

    public void setNdviMean3(BigDecimal ndviMean3) {
        this.ndviMean3 = ndviMean3;
    }

    public BigDecimal getNdbiMean3() {
        return ndbiMean3;
    }

    public void setNdbiMean3(BigDecimal ndbiMean3) {
        this.ndbiMean3 = ndbiMean3;
    }

    public BigDecimal getNdbiMean5() {
        return ndbiMean5;
    }

    public void setNdbiMean5(BigDecimal ndbiMean5) {
        this.ndbiMean5 = ndbiMean5;
    }

    public BigDecimal getNdbiStd3() {
        return ndbiStd3;
    }

    public void setNdbiStd3(BigDecimal ndbiStd3) {
        this.ndbiStd3 = ndbiStd3;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
