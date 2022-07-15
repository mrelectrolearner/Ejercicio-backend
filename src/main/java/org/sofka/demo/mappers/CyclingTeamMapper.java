package org.sofka.demo.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.model.CyclingTeamDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
@RequiredArgsConstructor
public class CyclingTeamMapper implements Mapper<CyclingTeam,CyclingTeamDto> {
    public final ModelMapper modelMapper;

    @Override
    public Function<CyclingTeamDto, CyclingTeam> convertDtoToEntity(){
        return dto-> modelMapper.map(dto,CyclingTeam.class);
    }


    @Override
    public Function<CyclingTeam, CyclingTeamDto> convertEntityToDto(){
        return entity->modelMapper.map(entity,CyclingTeamDto.class);
    }
}
