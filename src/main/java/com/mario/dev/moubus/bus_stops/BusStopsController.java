package com.mario.dev.moubus.bus_stops;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.mario.dev.moubus.bus_stops.dto.BusStopDTOCreate;
import com.mario.dev.moubus.bus_stops.entity.BusStop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/busStops")
public class BusStopsController {

    private final BusStopsService busStopsService;

    public BusStopsController(BusStopsService busStopsService) {
        this.busStopsService = busStopsService;
    }

    @PostMapping("")
    public ResponseEntity<BusStop> createBusStop(@RequestBody BusStopDTOCreate dto) {
        BusStop toret = busStopsService.save(dto);
        return ResponseEntity.created(
                UriComponentsBuilder.fromPath(
                        "/bus/stops/{id}").buildAndExpand(toret.getId()).toUri())
                .body(toret);
    }
}
