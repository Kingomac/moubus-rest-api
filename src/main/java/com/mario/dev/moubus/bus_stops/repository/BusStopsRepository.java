package com.mario.dev.moubus.bus_stops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mario.dev.moubus.bus_stops.entity.BusStop;

@Repository
public interface BusStopsRepository extends JpaRepository<BusStop, Long> {

}
