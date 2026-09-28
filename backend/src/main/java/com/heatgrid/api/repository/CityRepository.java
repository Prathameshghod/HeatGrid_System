package com.heatgrid.api.repository;

import com.heatgrid.api.entity.City;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//talks to mysql using JPA to perform CRUD operations on the City entity
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByOsmPlaceId(Long osmPlaceId);

    List<City> findByCityNameContainingIgnoreCase(String cityName);

    Optional<City> findByCityNameIgnoreCaseAndCountryIgnoreCase(String cityName, String country);
}
