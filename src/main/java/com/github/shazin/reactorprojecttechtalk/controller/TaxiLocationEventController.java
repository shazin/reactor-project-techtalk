package com.github.shazin.reactorprojecttechtalk.controller;

import com.github.shazin.reactorprojecttechtalk.domain.TaxiLocationEvent;
import com.github.shazin.reactorprojecttechtalk.service.TaxiLocationEventService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/taxilocationevents")
public class TaxiLocationEventController {

    private final TaxiLocationEventService taxiLocationEventService;

    public TaxiLocationEventController(TaxiLocationEventService taxiLocationEventService) {
        this.taxiLocationEventService = taxiLocationEventService;
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<TaxiLocationEvent> getAllTaxiLocationEvents() {
        return taxiLocationEventService.getTaxiLocationEvents().log();
    }

    @PostMapping(consumes = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Void> saveTaxiLocationEvent(@RequestBody Flux<TaxiLocationEvent> taxiLocationEventFlux) {
        return taxiLocationEventService.saveAll(taxiLocationEventFlux);
    }
}
