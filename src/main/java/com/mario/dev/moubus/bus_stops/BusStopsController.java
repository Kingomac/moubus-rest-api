package com.mario.dev.moubus.bus_stops;

import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mario.dev.moubus.bus_stops.dto.BusStopDTO;
import com.mario.dev.moubus.bus_stops.entity.BusStop;

@RestController
@RequestMapping("/api/helper/busStops")
public class BusStopsController {

    private final BusStopsService busStopsService;
    private final RepositoryEntityLinks entityLinks;

    public BusStopsController(BusStopsService busStopsService, RepositoryEntityLinks entityLinks) {
        this.busStopsService = busStopsService;
        this.entityLinks = entityLinks;
    }

    @PostMapping("")
    public ResponseEntity<EntityModel<BusStop>> createBusStop(@RequestBody BusStopDTO dto) {
        BusStop toret = busStopsService.save(dto);
        Link selfUri = entityLinks.linkToItemResource(BusStop.class, toret.getId()).withSelfRel();
        EntityModel<BusStop> resource = EntityModel.of(toret);
        resource.add(selfUri);
        return ResponseEntity.created(
                selfUri.toUri())
                .body(resource);
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityModel<BusStop>> updateBusStop(@PathVariable String id, @RequestBody BusStopDTO entity) {
        BusStop toret = busStopsService.update(Long.parseLong(id), entity);
        Link selfUri = entityLinks.linkToItemResource(BusStop.class, toret.getId()).withSelfRel();
        EntityModel<BusStop> resource = EntityModel.of(toret);
        resource.add(selfUri);
        return ResponseEntity.ok(resource);
    }
}
