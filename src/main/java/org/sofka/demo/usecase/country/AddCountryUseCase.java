package org.sofka.demo.usecase.country;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.mappers.CountryMapper;
import org.sofka.demo.mappers.CyclingTeamMapper;
import org.sofka.demo.mappers.CyclistMapper;
import org.sofka.demo.model.CountryDto;
import org.sofka.demo.repository.CountryRepository;
import org.sofka.demo.usecase.cyclingTeam.AddCyclingTeamUseCase;
import org.sofka.demo.usecase.cyclist.AddCyclistUseCase;
import org.sofka.demo.utilities.Util;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddCountryUseCase {

    private final CountryRepository countryRepository;
    private final CountryMapper mapper;

    public Mono<CountryDto> apply(CountryDto countryDto){


        log.info("\\n***** Saving country *****\\n\"");
        return Util.save(countryRepository,mapper).apply(countryDto);


    }


}

