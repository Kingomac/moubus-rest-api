package com.mario.dev.moubus.bus_stops;

import java.util.logging.Logger;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.mario.dev.moubus.bus_stops.dto.BusStopDTO;
import com.mario.dev.moubus.bus_stops.entity.BusStop;
import com.mario.dev.moubus.bus_stops.repository.BusStopsRepository;
import com.mario.dev.moubus.common.CoordinatesConverter;
import com.mario.dev.moubus.common.CoordinatesConverter.Coordinates;

@Service
public class BusStopsService {

    private final BusStopsRepository busStopsRepository;

    public BusStopsService(BusStopsRepository busStopsRepository) {
        this.busStopsRepository = busStopsRepository;
    }

    public BusStop save(BusStopDTO dto) {
        BusStop busStop = new BusStop();
        busStop.setStreet(dto.street());
        busStop.setCity(dto.city());
        busStop.setProvince(dto.province());

        Coordinates cords = CoordinatesConverter.strToDouble(dto.coordinates());
        busStop.setLatitude(cords.latitude());
        busStop.setLongitude(cords.longitude());

        return busStopsRepository.save(busStop);
    }

    public BusStop update(Long id, BusStopDTO dto) {
        BusStop busStop = busStopsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus stop not found"));
        busStop.setStreet(dto.street());
        busStop.setCity(dto.city());
        busStop.setProvince(dto.province());

        Coordinates cords = CoordinatesConverter.strToDouble(dto.coordinates());
        System.out.println("CHANGING COORDINATES TO: " + cords.latitude() + " " + cords.longitude());
        busStop.setLatitude(cords.latitude());
        busStop.setLongitude(cords.longitude());

        return busStopsRepository.save(busStop);
    }
}
