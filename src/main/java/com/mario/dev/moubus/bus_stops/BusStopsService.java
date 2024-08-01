package com.mario.dev.moubus.bus_stops;

import org.springframework.stereotype.Service;

import com.mario.dev.moubus.bus_stops.dto.BusStopDTOCreate;
import com.mario.dev.moubus.bus_stops.entity.BusStop;
import com.mario.dev.moubus.bus_stops.repository.BusStopsRepository;

@Service
public class BusStopsService {

    private final BusStopsRepository busStopsRepository;

    public BusStopsService(BusStopsRepository busStopsRepository) {
        this.busStopsRepository = busStopsRepository;
    }

    public BusStop save(BusStopDTOCreate dto) {
        BusStop busStop = new BusStop();
        busStop.setStreet(dto.street());
        busStop.setCity(dto.city());
        busStop.setProvince(dto.province());

        return busStopsRepository.save(busStop);
    }
}
