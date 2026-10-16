package com.heatgrid.api.repository;

import com.heatgrid.api.entity.City;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findFirstByCityNameIgnoreCase(String cityName);
}
