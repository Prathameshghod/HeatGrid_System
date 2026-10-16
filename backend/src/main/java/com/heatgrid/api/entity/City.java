package com.heatgrid.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name", nullable = false, length = 255)
    private String cityName;

    @Column(length = 255)
    private String state;

    @Column(length = 255)
    private String country;

    @Column(precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "osm_place_id")
    private Long osmPlaceId;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    protected City() {}

    public City(String cityName, String state, String country, BigDecimal latitude,
                BigDecimal longitude, Long osmPlaceId) {
        this.cityName = cityName;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.osmPlaceId = osmPlaceId;
    }

    public Long getId() { return id; }
    public String getCityName() { return cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public BigDecimal getLatitude() { return latitude; }
    public void setLatitude(BigDecimal latitude) { this.latitude = latitude; }
    public BigDecimal getLongitude() { return longitude; }
    public void setLongitude(BigDecimal longitude) { this.longitude = longitude; }
    public Long getOsmPlaceId() { return osmPlaceId; }
    public void setOsmPlaceId(Long osmPlaceId) { this.osmPlaceId = osmPlaceId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
