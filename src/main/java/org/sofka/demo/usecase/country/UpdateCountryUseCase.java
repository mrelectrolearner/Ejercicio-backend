package org.sofka.demo.usecase.country;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.mappers.CountryMapper;
import org.sofka.demo.model.CountryDto;
import org.sofka.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateCountryUseCase {
    private CountryRepository countryRepository;
    private CountryMapper mapper;
    private CreateCountryUseCase createCountryUseCase;

    public CountryDto apply(Integer id,CountryDto toUpdateCountryDto){
        log.info("\\n***** Updating country *****\\n\"");
        CountryDto newCountryDto =countryRepository
                .findById(id)
                .stream()
                .map(country -> mapper.convertEntityToDto().apply(country))
                .findFirst()
                .orElse(new CountryDto());

        newCountryDto.setId(id);
        newCountryDto.setCode(toUpdateCountryDto.getCode());
        newCountryDto.setName(toUpdateCountryDto.getName());

        return createCountryUseCase.apply(newCountryDto);
    }
}
