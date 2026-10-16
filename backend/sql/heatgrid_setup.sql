-- HeatGrid database schema matching the application JPA entities.
-- Run this script in MySQL Workbench using a MySQL account with CREATE/ALTER privileges.

CREATE DATABASE IF NOT EXISTS heatgrid_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE heatgrid_db;

CREATE TABLE IF NOT EXISTS cities (
    id BIGINT NOT NULL AUTO_INCREMENT,
    city_name VARCHAR(255) NOT NULL,
    state VARCHAR(255),
    country VARCHAR(255),
    latitude DECIMAL(10,7),
    longitude DECIMAL(10,7),
    osm_place_id BIGINT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    INDEX idx_cities_city_name (city_name)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS heat_zones (
    id BIGINT NOT NULL AUTO_INCREMENT,
    city_id BIGINT NOT NULL,
    zone_name VARCHAR(255),
    latitude DECIMAL(10,7),
    longitude DECIMAL(10,7),
    heat_score DECIMAL(8,4),
    risk_level VARCHAR(255),
    ndvi DECIMAL(8,5),
    ndbi DECIMAL(8,5),
    water_coverage DECIMAL(8,5),
    elevation DECIMAL(10,2),
    ndvi_mean3 DECIMAL(8,5),
    ndbi_mean3 DECIMAL(8,5),
    ndbi_mean5 DECIMAL(8,5),
    ndbi_std3 DECIMAL(8,5),
    acquisition_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    INDEX idx_heat_zones_city_id (city_id),
    CONSTRAINT fk_heat_zones_city FOREIGN KEY (city_id)
      REFERENCES cities (id) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS interventions (
    id BIGINT NOT NULL AUTO_INCREMENT,
    city_id BIGINT NOT NULL,
    heat_zone_id BIGINT,
    intervention_type VARCHAR(255),
    title VARCHAR(255),
    description TEXT,
    priority VARCHAR(255),
    estimated_impact DECIMAL(8,4),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    INDEX idx_interventions_city_id (city_id),
    INDEX idx_interventions_heat_zone_id (heat_zone_id),
    CONSTRAINT fk_interventions_city FOREIGN KEY (city_id)
      REFERENCES cities (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_interventions_heat_zone FOREIGN KEY (heat_zone_id)
      REFERENCES heat_zones (id) ON UPDATE CASCADE ON DELETE SET NULL
) ENGINE=InnoDB;

-- Migrate existing tables from the earlier schema shown in the screenshots.
ALTER TABLE cities
    MODIFY latitude DECIMAL(10,7),
    MODIFY longitude DECIMAL(10,7),
    MODIFY created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE heat_zones
    MODIFY latitude DECIMAL(10,7),
    MODIFY longitude DECIMAL(10,7),
    MODIFY created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

SET @has_acquisition_date = (
    SELECT COUNT(*)
    FROM information_schema.COLUMNS
    WHERE TABLE_SCHEMA = DATABASE()
      AND TABLE_NAME = 'heat_zones'
      AND COLUMN_NAME = 'acquisition_date'
);
SET @add_acquisition_date = IF(
    @has_acquisition_date = 0,
    'ALTER TABLE heat_zones ADD COLUMN acquisition_date DATE NULL AFTER ndbi_std3',
    'SELECT 1'
);
PREPARE acquisition_date_stmt FROM @add_acquisition_date;
EXECUTE acquisition_date_stmt;
DEALLOCATE PREPARE acquisition_date_stmt;

ALTER TABLE interventions
    MODIFY created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
