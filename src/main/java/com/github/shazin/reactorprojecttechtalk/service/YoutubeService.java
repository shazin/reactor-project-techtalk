package com.github.shazin.reactorprojecttechtalk.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class YoutubeService {

    public Flux getPackets() {
        return Flux.interval(Duration.ofSeconds(1)).map(s -> "Packet "+s);
    }
}