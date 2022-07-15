package org.sofka.demo.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.model.CountryDto;
import org.sofka.demo.usecase.country.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class CountryController {

	@Autowired
	GetCountryUseCase getCountryUseCase;

	@Autowired
	GetCountryByCodeUseCase getCountryByCodeUseCase;

	@Autowired
	AddCountryUseCase addCountryUseCase;

	@Autowired
	UpdateCountryUseCase updateCountryUseCase;

	
	@GetMapping("/api/countries")
	public ResponseEntity<Flux<CountryDto>> findAllCountries() {
		return ResponseEntity.ok().body(getCountryUseCase.apply());
	}
	
	@GetMapping("/api/country/{code}")
	public ResponseEntity<Mono<CountryDto>> findCountryByCode(@PathVariable(name = "code") String code) {
		return ResponseEntity.ok().body(getCountryByCodeUseCase.apply(code));
	}
	
	@PostMapping("/api/newCountry")
	public ResponseEntity<Mono<CountryDto>> saveCountry(@Validated @RequestBody CountryDto country) {
		return ResponseEntity.ok().body(addCountryUseCase.apply(country));
	}
	
	@PutMapping("api/country/{id}")
	public ResponseEntity<Mono<CountryDto>> updateCountry(@RequestBody CountryDto toUpdateCountry, @PathVariable String id) {
		return ResponseEntity.ok().body(updateCountryUseCase.apply(id, toUpdateCountry));
	}
	
	@DeleteMapping("/api/country/{id}")
	public ResponseEntity<Void> deleteCountry(@PathVariable String id, DeleteCountryUseCase useCase) {
		useCase.apply(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
