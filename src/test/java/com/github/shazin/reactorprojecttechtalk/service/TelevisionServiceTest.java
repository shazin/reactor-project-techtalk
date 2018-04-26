package com.github.shazin.reactorprojecttechtalk.service;

import org.junit.Test;
import reactor.core.publisher.ConnectableFlux;

public class TelevisionServiceTest {

    private TelevisionService televisionService = new TelevisionService();

    @Test
    public void hotFluxTest() throws Exception {
        ConnectableFlux hotFlux = televisionService.getTransmission();

        hotFlux.subscribe(c -> System.out.println("Subscribe 1 : "+c));
        hotFlux.connect();

        Thread.sleep(5000);

        hotFlux.subscribe(c -> System.out.println("Subscribe 2 : "+c));

        Thread.sleep(10000);
    }
}
