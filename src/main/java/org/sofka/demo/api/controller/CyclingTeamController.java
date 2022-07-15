package org.sofka.demo.api.controller;

import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.repository.CyclingTeamRepository;
import org.sofka.demo.usecase.cyclingTeam.AddCyclingTeamUseCase;
import org.sofka.demo.usecase.cyclingTeam.GetCyclingTeamByTeamCodeUseCase;
import org.sofka.demo.usecase.cyclingTeam.GetCyclingTeamUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CyclingTeamController {
	@Autowired
	CyclingTeamRepository teamRepository;

	@Autowired
	 GetCyclingTeamByTeamCodeUseCase getCyclingTeamByTeamCodeUseCase;

	@Autowired
	 GetCyclingTeamUseCase getCyclingTeamUseCase;

	@Autowired
	AddCyclingTeamUseCase addCyclingTeamUseCase;
	@GetMapping("/api/teams")
	public Flux<CyclingTeamDto> findAllCyclingTeams() {

		return getCyclingTeamUseCase.apply();
	}
	
	@PostMapping("/api/newTeam")
	public Mono<CyclingTeamDto> saveCyclingTeam(@Validated @RequestBody CyclingTeamDto newTeam) {
		return addCyclingTeamUseCase.apply(newTeam);
	}
	
	@GetMapping("/api/team/{team_code}")
	public ResponseEntity<Mono<CyclingTeamDto>> findCyclingTeamByCode(@PathVariable(name = "team_code") String teamCode) {
		return ResponseEntity.ok().body(getCyclingTeamByTeamCodeUseCase.apply(teamCode));
	}
}
