package com.github.shazin.reactorprojecttechtalk.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class TelevisionService {

    public ConnectableFlux getTransmission() {
        return Flux.interval(Duration.ofSeconds(1)).map(s -> "Transmission "+s).publish();
    }
}