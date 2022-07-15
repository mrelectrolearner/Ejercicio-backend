package org.sofka.demo.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.sofka.demo.domain.Country;
import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.model.CountryDto;
import org.sofka.demo.model.CyclingTeamDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
@RequiredArgsConstructor
public class CyclingMapper {
    public ModelMapper modelMapper;

    public Function<CyclingTeamDto, CyclingTeam> convertDtoToEntity(){
        return dto-> modelMapper.map(dto,CyclingTeam.class);
    }


    public Function<CyclingTeam, CyclingTeamDto> convertEntityToDto(){
        return entity->modelMapper.map(entity,CyclingTeamDto.class);
    }
}
