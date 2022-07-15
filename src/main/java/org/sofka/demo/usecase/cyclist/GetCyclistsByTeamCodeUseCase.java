package org.sofka.demo.usecase.cyclist;

import lombok.RequiredArgsConstructor;
import org.sofka.demo.domain.Cyclist;
import org.sofka.demo.mappers.CyclistMapper;
import org.sofka.demo.model.CyclistDto;
import org.sofka.demo.repository.CyclistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class GetCyclistsByTeamCodeUseCase {
    CyclistRepository cyclistRepository;
    CyclistMapper cyclistMapper;

    public List<CyclistDto> apply(String teamCode){
        List<Cyclist> cyclists = cyclistRepository.findByCyclingTeamTeamCode(teamCode);
        return cyclists
                .stream()
                .map(cyclist -> cyclistMapper.convertEntityToDto().apply(cyclist))
                .collect(Collectors.toList());

    }
}
