package org.sofka.demo.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.repository.CyclingTeamRepository;
import org.sofka.demo.usecase.cyclingTeam.CreateCyclingTeamUseCase;
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

@RestController
public class CyclingTeamController {
	@Autowired
	CyclingTeamRepository teamRepository;

	@Autowired
	 GetCyclingTeamByTeamCodeUseCase getCyclingTeamByTeamCodeUseCase;

	@Autowired
	 GetCyclingTeamUseCase getCyclingTeamUseCase;

	@Autowired
	 CreateCyclingTeamUseCase createCyclingTeamUseCase;
	@GetMapping("/api/teams")
	public List<CyclingTeamDto> findAllCyclingTeams() {

		return getCyclingTeamUseCase.apply();
	}
	
	@PostMapping("/api/newTeam")
	public CyclingTeamDto saveCyclingTeam(@Validated @RequestBody CyclingTeamDto newTeam) {
		return createCyclingTeamUseCase.apply(newTeam);
	}
	
	@GetMapping("/api/team/{team_code}")
	public ResponseEntity<CyclingTeamDto> findCyclingTeamByCode(@PathVariable(name = "team_code") String teamCode) {
		CyclingTeamDto team = getCyclingTeamByTeamCodeUseCase.apply(teamCode);
		return ResponseEntity.ok().body(team);
	}
}
