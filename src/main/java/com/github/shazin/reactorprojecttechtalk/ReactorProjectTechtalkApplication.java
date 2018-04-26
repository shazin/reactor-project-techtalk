package com.github.shazin.reactorprojecttechtalk;

import com.github.shazin.reactorprojecttechtalk.domain.TaxiLocationEvent;
import com.github.shazin.reactorprojecttechtalk.util.GeoUtil;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;

@SpringBootApplication
public class ReactorProjectTechtalkApplication {

	public static void main(String[] args) {
		//System.setProperty("os.arch", "x86_64");
		SpringApplication.run(ReactorProjectTechtalkApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(MongoOperations mongoOperations) {
		return args -> {
			mongoOperations.dropCollection(TaxiLocationEvent.class);
			mongoOperations.createCollection(TaxiLocationEvent.class, CollectionOptions.empty().size(1000000).capped());

			Flux.range(0, 10)
					.map(i -> new TaxiLocationEvent(UUID.randomUUID().toString(), "VIP", GeoUtil.getLocation(79.865072, 6.927610, 30)))
					.doOnNext(mongoOperations::save)
					.blockLast(Duration.ofSeconds(5));
		};
	}

}
