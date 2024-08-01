package com.mario.dev.moubus.bus_stops;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.mario.dev.moubus.bus_stops.dto.BusStopDTOCreate;
import com.mario.dev.moubus.bus_stops.entity.BusStop;

import java.net.URI;

import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.TemplateVariables;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public ResponseEntity<EntityModel<BusStop>> createBusStop(@RequestBody BusStopDTOCreate dto) {
        BusStop toret = busStopsService.save(dto);
        Link selfUri = entityLinks.linkToItemResource(BusStop.class, toret.getId()).withSelfRel();
        EntityModel<BusStop> resource = EntityModel.of(toret);
        resource.add(selfUri);
        return ResponseEntity.created(
                selfUri.toUri())
                .body(resource);
    }
}
