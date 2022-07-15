package org.sofka.demo.usecase.cyclist;

import lombok.RequiredArgsConstructor;
import org.sofka.demo.domain.Cyclist;
import org.sofka.demo.mappers.CyclistMapper;
import org.sofka.demo.model.CyclistDto;
import org.sofka.demo.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class GetCyclistsByTeamCodeUseCase {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Flux<CyclistDto> apply(String teamCode){
        return cyclistRepository
                .findByCyclingTeamTeamCode(teamCode)
                .map(cyclist -> cyclistMapper.convertEntityToDto().apply(cyclist));

    }
}
