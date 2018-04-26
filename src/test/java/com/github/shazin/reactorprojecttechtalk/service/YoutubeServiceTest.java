package com.github.shazin.reactorprojecttechtalk.service;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class YoutubeServiceTest {

    private YoutubeService youtubeService = new YoutubeService();

    @Test
    public void coldFluxTest() throws Exception {
        Flux packets1 = youtubeService.getPackets();
        packets1.subscribe(c -> System.out.println("Packet Receiver 1 : "+c));

        Thread.sleep(5000);

        Flux packets2 = youtubeService.getPackets();
        packets2.subscribe(c -> System.out.println("Packet Receiver 2 : "+c));

        Thread.sleep(10000);
    }
}