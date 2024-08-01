package com.mario.dev.moubus.bus_lines.entity;

import java.time.LocalTime;

import com.mario.dev.moubus.bus_lines.Repeats;
import com.mario.dev.moubus.bus_management.entity.Bus;
import com.mario.dev.moubus.users.entity.Driver;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class BusLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalTime departureTime;
    private Repeats repeats;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Driver> driver;

    @ManyToOne
    private Bus bus;
}
