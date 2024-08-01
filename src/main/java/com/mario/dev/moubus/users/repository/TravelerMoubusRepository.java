package com.mario.dev.moubus.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.mario.dev.moubus.users.entity.TravelerMoubus;

@Repository
public interface TravelerMoubusRepository extends
        JpaRepository<TravelerMoubus, Long> {

}
