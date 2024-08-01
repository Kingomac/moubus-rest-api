package com.mario.dev.moubus.tickets.entity;

import com.mario.dev.moubus.bus_lines.entity.BusLine;
import com.mario.dev.moubus.users.entity.Traveler;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class BusTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketNumber;
    private double price;

    @OneToOne
    private Traveler traveler;

    @OneToOne
    private BusLine busLine;
}
