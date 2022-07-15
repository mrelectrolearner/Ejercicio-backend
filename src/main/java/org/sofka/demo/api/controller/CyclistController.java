package org.sofka.demo.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.sofka.demo.domain.Cyclist;
import org.sofka.demo.model.CyclistDto;
import org.sofka.demo.repository.CyclistRepository;
import org.sofka.demo.usecase.cyclist.AddCyclistUseCase;
import org.sofka.demo.usecase.cyclist.GetAllCyclistsUseCase;
import org.sofka.demo.usecase.cyclist.GetCyclistByCompetitorNumber;
import org.sofka.demo.usecase.cyclist.GetCyclistsByTeamCodeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CyclistController {
	@Autowired
	private CyclistRepository cyclistRepository;

	@Autowired
	AddCyclistUseCase addCyclistUseCase;

	@Autowired
	GetCyclistsByTeamCodeUseCase getCyclistsByTeamCodeUseCase;

	@Autowired
	GetCyclistByCompetitorNumber getCyclistByCompetitorNumber;

	 @Autowired
	GetAllCyclistsUseCase getAllCyclistsUseCase;
	
	@GetMapping("/api/cyclists")
	public ResponseEntity<Flux<CyclistDto>> findAllCyclists(@RequestParam Map<String, String> reqParam) {
		if (!reqParam.isEmpty()) return ResponseEntity.badRequest().build();
		return ResponseEntity.ok().body(getAllCyclistsUseCase.apply());
	}
	
	@PostMapping("/api/newCyclist")
	public Mono<CyclistDto> saveNewCyclist(@Validated @RequestBody CyclistDto newCyclist) {
		return addCyclistUseCase.apply(newCyclist);
	}
	
	@GetMapping("/api/cyclist/{competitorNumber}")
	public ResponseEntity<Mono<CyclistDto>> findCyclistByCompetitorNumber(@PathVariable(name = "competitorNumber") String competitorNumber) {
		return ResponseEntity.ok().body(getCyclistByCompetitorNumber.apply(competitorNumber));
	}
	
	@RequestMapping(value = "/api/cyclists", method = RequestMethod.GET, params = "teamCode")
	public Flux<CyclistDto> findCyclistsByTeamCode(	@RequestParam(name = "teamCode") String teamCode) {
		return getCyclistsByTeamCodeUseCase.apply(teamCode);
	}

}
