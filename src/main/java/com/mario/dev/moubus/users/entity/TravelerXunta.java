package com.mario.dev.moubus.users.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class TravelerXunta extends Traveler {
    private String xuntaCardNumber;
}
