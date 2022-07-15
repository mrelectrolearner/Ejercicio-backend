package org.sofka.demo.repository;

import java.util.Optional;

import org.sofka.demo.domain.Country;
import org.sofka.demo.domain.CyclingTeam;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Mono;

public interface CyclingTeamRepository extends ReactiveMongoRepository<CyclingTeam,String> {
	public Mono<CyclingTeam> findCyclingTeamByTeamCode(String teamCode);
}
