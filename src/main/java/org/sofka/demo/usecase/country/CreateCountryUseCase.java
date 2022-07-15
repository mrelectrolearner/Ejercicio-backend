package org.sofka.demo.usecase.country;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.domain.Country;
import org.sofka.demo.mappers.CountryMapper;
import org.sofka.demo.model.CountryDto;
import org.sofka.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateCountryUseCase {
    private CountryRepository countryRepository;
    private CountryMapper mapper;

    public CountryDto apply(CountryDto countryDto){
        log.info("\\n***** Saving country *****\\n\"");
        Country country=countryRepository.save(mapper.convertDtoToEntity().apply(countryDto));
        return mapper.convertEntityToDto().apply(country);
    }
}
