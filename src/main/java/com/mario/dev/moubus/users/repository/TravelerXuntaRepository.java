package com.mario.dev.moubus.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.mario.dev.moubus.users.entity.TravelerXunta;

@Repository
@RepositoryRestResource(path = "travelersXunta", collectionResourceRel = "travelersXunta")
public interface TravelerXuntaRepository extends JpaRepository<TravelerXunta, Long> {

}
