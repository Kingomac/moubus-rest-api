package com.mario.dev.moubus.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mario.dev.moubus.users.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
