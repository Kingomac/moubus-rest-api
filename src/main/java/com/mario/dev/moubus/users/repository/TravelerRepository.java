package com.mario.dev.moubus.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.mario.dev.moubus.users.entity.Traveler;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {
}
