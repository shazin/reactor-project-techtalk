package com.github.shazin.reactorprojecttechtalk;

import com.github.shazin.reactorprojecttechtalk.domain.TaxiLocationEvent;
import com.github.shazin.reactorprojecttechtalk.util.GeoUtil;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;

public class TaxiLocationEventUpdater {

    public static void main(String... args) {
        WebClient webClient = WebClient.create("http://localhost:8080");

        Flux<TaxiLocationEvent> taxiLocationEvents = Flux.interval(Duration.ofSeconds(2)).map(i -> new TaxiLocationEvent(UUID.randomUUID().toString(), "VIP", GeoUtil.getLocation(79.865072, 6.927610, 30)));

        webClient
                .post()
                .uri("/taxilocationevents")
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(taxiLocationEvents, TaxiLocationEvent.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
