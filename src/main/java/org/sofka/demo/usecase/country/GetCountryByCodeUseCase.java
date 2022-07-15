package org.sofka.demo.usecase.country;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.domain.Country;
import org.sofka.demo.mappers.CountryMapper;
import org.sofka.demo.model.CountryDto;
import org.sofka.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetCountryByCodeUseCase {

    private final CountryRepository countryRepository;
    private final CountryMapper mapper;

    public Mono<CountryDto> apply (String code){
        log.info("\n***** Getting country by code *****\n");
        return countryRepository
                .findCountryByCode(code)
                .map(country1 -> mapper
                        .convertEntityToDto()
                        .apply(country1));
    }
}
