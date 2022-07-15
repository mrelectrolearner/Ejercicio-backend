package org.sofka.demo.usecase.country;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.mappers.CountryMapper;
import org.sofka.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteCountryUseCase {
    private final CountryRepository countryRepository;
    private final CountryMapper mapper;

    public Mono<Boolean> apply(String id){
        log.info("\n***** Deleting country *****\n");
       countryRepository.deleteById(id);
       return countryRepository.existsById(id);
    }
}
