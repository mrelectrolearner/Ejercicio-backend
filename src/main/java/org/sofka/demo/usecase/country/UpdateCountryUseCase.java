package org.sofka.demo.usecase.country;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.mappers.CountryMapper;
import org.sofka.demo.model.CountryDto;
import org.sofka.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateCountryUseCase {
    private final CountryRepository countryRepository;
    private final CountryMapper mapper;
    private final AddCountryUseCase addCountryUseCase;

    public Mono<CountryDto> apply(String id, CountryDto toUpdateCountryDto){
        log.info("\\n***** Updating country *****\\n\"");
        Mono<CountryDto> newCountryDto =countryRepository
                .findById(id)
                .map(country -> mapper.convertEntityToDto().apply(country)).map(countryDto -> {
                    countryDto.setId(id);
                    countryDto.setCode(toUpdateCountryDto.getCode());
                    countryDto.setName(toUpdateCountryDto.getName());
                    return countryDto;
                });

        return newCountryDto.flatMap(addCountryUseCase::apply);
    }
}
