package com.github.shazin.reactorprojecttechtalk.repo;

import com.github.shazin.reactorprojecttechtalk.domain.TaxiLocationEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface TaxiLocationEventRepository extends ReactiveMongoRepository<TaxiLocationEvent, String> {

    @Tailable
    Flux<TaxiLocationEvent> findTaxiLocationEventBy();
}
