package org.sofka.demo.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.domain.Cyclist;
import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.model.CyclistDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
@RequiredArgsConstructor
public class CyclistMapper {
    public ModelMapper modelMapper;

    public Function<CyclistDto, Cyclist> convertDtoToEntity(){
        return dto-> modelMapper.map(dto,Cyclist.class);
    }


    public Function<Cyclist, CyclistDto> convertEntityToDto(){
        return entity->modelMapper.map(entity,CyclistDto.class);
    }
}
