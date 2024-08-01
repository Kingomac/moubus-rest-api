package com.mario.dev.moubus.bus_stops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.mario.dev.moubus.bus_stops.entity.BusStop;

import jakarta.persistence.Entity;

@Repository
@RestResource(path = "busStops", rel = "bus-stops")
public interface BusStopsRepository extends JpaRepository<BusStop, Long> {

    @Override
    @RestResource(exported = false)
    <S extends BusStop> S save(S entity);
}
