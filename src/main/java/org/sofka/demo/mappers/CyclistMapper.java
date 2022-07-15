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
public class CyclistMapper implements Mapper<Cyclist,CyclistDto>{
    public final ModelMapper modelMapper;

    @Override
    public Function<CyclistDto, Cyclist> convertDtoToEntity(){
        return dto-> modelMapper.map(dto,Cyclist.class);
    }


    @Override
    public Function<Cyclist, CyclistDto> convertEntityToDto(){
        return entity->modelMapper.map(entity,CyclistDto.class);
    }
}
