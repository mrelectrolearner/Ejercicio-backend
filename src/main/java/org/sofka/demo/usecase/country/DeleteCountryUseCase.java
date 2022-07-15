package org.sofka.demo.usecase.country;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.mappers.CountryMapper;
import org.sofka.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteCountryUseCase {
    private CountryRepository countryRepository;
    private CountryMapper mapper;

    public boolean apply(Integer id){
        log.info("\n***** Deleting country *****\n");
       countryRepository.deleteById(id);
       return countryRepository.existsById(id);
    }
}
