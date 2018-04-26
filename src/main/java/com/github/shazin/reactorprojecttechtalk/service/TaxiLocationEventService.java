package com.github.shazin.reactorprojecttechtalk.service;

import com.github.shazin.reactorprojecttechtalk.domain.TaxiLocationEvent;
import com.github.shazin.reactorprojecttechtalk.repo.TaxiLocationEventRepository;
import com.github.shazin.reactorprojecttechtalk.util.GeoUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.UUID;

@Service
public class TaxiLocationEventService {

    private final TaxiLocationEventRepository taxiLocationEventRepository;

    public TaxiLocationEventService(TaxiLocationEventRepository taxiLocationEventRepository) {
        this.taxiLocationEventRepository = taxiLocationEventRepository;
    }

    public Flux<TaxiLocationEvent> getTaxiLocationEvents() {
        return taxiLocationEventRepository.findTaxiLocationEventBy();
    }

    public Mono<Void> saveAll(Flux<TaxiLocationEvent> taxiLocationEvent) {
        return taxiLocationEventRepository.insert(taxiLocationEvent).then();
    }
}
