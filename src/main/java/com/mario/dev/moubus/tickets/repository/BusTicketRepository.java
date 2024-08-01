package com.mario.dev.moubus.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mario.dev.moubus.tickets.entity.BusTicket;

@Repository
public interface BusTicketRepository extends JpaRepository<BusTicket, Long> {

}
