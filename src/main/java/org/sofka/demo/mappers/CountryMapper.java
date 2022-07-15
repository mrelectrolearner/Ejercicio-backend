package org.sofka.demo.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.sofka.demo.domain.Country;
import org.sofka.demo.model.CountryDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CountryMapper implements Mapper<Country,CountryDto> {

    public final ModelMapper modelMapper;

    @Override
    public Function<CountryDto,Country> convertDtoToEntity(){
        return dto-> modelMapper.map(dto,Country.class);
    }

    @Override

    public Function<Country, CountryDto> convertEntityToDto(){
        return entity->modelMapper.map(entity,CountryDto.class);
    }
}
