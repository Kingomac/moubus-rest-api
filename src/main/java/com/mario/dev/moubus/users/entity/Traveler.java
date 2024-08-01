package com.mario.dev.moubus.users.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Traveler extends Person {
    private Boolean wantsPromotions;
}
