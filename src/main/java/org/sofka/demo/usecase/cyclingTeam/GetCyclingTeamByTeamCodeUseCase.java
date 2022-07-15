package org.sofka.demo.usecase.cyclingTeam;

import lombok.RequiredArgsConstructor;
import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.mappers.CyclingTeamMapper;
import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.repository.CyclingTeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetCyclingTeamByTeamCodeUseCase {
    private final CyclingTeamRepository cyclingTeamRepository;
    private final CyclingTeamMapper mapper;

    public Mono<CyclingTeamDto> apply(String teamCode){
        Mono<CyclingTeam> cyclingTeamFound = cyclingTeamRepository.findCyclingTeamByTeamCode(teamCode);
        return cyclingTeamFound.map(cyclingTeam -> mapper.convertEntityToDto().apply(cyclingTeam));

    }
}
