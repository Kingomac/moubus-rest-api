package com.mario.dev.moubus.bus_lines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mario.dev.moubus.bus_lines.entity.BusLine;

@Repository
public interface BusLineRepository extends JpaRepository<BusLine, Long> {

}
