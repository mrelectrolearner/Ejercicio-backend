package org.sofka.demo.usecase.country;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.domain.Country;
import org.sofka.demo.mappers.CountryMapper;
import org.sofka.demo.model.CountryDto;
import org.sofka.demo.repository.CountryRepository;
import org.sofka.demo.utilities.Util;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetCountryUseCase {

    private final CountryRepository countryRepository;
    private final CountryMapper mapper;

    public Flux<CountryDto> apply (){
        log.info("\n***** Getting All countries *****\n");
        return countryRepository
                .findAll()
                .map(country ->mapper
                        .convertEntityToDto()
                        .apply(country) );
    }


}
