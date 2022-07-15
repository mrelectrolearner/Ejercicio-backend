package org.sofka.demo.repository;

import java.util.List;
import java.util.Optional;

import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.domain.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CyclistRepository extends ReactiveMongoRepository<Cyclist, String> {
	public Mono<Cyclist> findCyclistByCompetitorNumber(String competitorNumber);
	public Flux<Cyclist> findByCyclingTeamTeamCode(String teamCode);
}
