package com.mario.dev.moubus.users.entity;

import java.util.List;

import com.mario.dev.moubus.bus_lines.entity.BusLine;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Driver extends Person {
    private double monthlySalary;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<BusLine> busLinesAssigned;

}
