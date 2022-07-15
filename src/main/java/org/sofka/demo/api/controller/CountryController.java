package org.sofka.demo.api.controller;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.domain.Country;
import org.sofka.demo.model.CountryDto;
import org.sofka.demo.repository.CountryRepository;
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

@RestController
@Slf4j
public class CountryController {

	@Autowired
	public GetCountryUseCase getCountryUseCase;

	@Autowired
	GetCountryByCodeUseCase getCountryByCodeUseCase;

	@Autowired
	CreateCountryUseCase createCountryUseCase;

	@Autowired
	UpdateCountryUseCase updateCountryUseCase;

	
	@GetMapping("/api/countries")
	public ResponseEntity<List<CountryDto>> findAllCountries() {
		return ResponseEntity.ok().body(getCountryUseCase.apply());
	}
	
	@GetMapping("/api/country/{code}")
	public ResponseEntity<CountryDto> findCountryByCode(@PathVariable(name = "code") String code) {
		Optional<CountryDto> countryDto = getCountryByCodeUseCase.apply(code);
		if (countryDto.isPresent()) {
			return ResponseEntity.ok().body(countryDto.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/api/newCountry")
	public ResponseEntity<CountryDto> saveCountry(@Validated @RequestBody CountryDto country) {
		return ResponseEntity.ok().body(createCountryUseCase.apply(country));
	}
	
	@PutMapping("api/country/{id}")
	public ResponseEntity<CountryDto> updateCountry(@RequestBody CountryDto toUpdateCountry, @PathVariable int id) {
		return ResponseEntity.ok().body(updateCountryUseCase.apply(id, toUpdateCountry));
	}
	
	@DeleteMapping("/api/country/{id}")
	public ResponseEntity<Void> deleteCountry(@PathVariable int id, DeleteCountryUseCase useCase) {
		useCase.apply(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
