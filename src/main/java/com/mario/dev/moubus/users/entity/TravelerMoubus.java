package com.mario.dev.moubus.users.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class TravelerMoubus extends Traveler {
    private String monbusCardNumber;
}
