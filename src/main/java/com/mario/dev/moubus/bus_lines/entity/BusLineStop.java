package com.mario.dev.moubus.bus_lines.entity;

import java.time.Duration;

import com.mario.dev.moubus.bus_stops.entity.BusStop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class BusLineStop {

    @Id
    @OneToOne
    private BusStop busStop;

    @Id
    @OneToOne
    private BusLine busLine;
    private Duration durationFromLastStop;
}
