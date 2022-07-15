package org.sofka.demo.usecase.cyclingTeam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.mappers.CyclingTeamMapper;
import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.repository.CyclingTeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetCyclingTeamUseCase {
    private final CyclingTeamRepository cyclingTeamRepository;
    private final CyclingTeamMapper mapper;

    public Flux<CyclingTeamDto> apply(){

        log.info("\n***** Getting All cycling teams *****\n");
        return cyclingTeamRepository.findAll()
                .map(country ->mapper
                        .convertEntityToDto()
                        .apply(country));
    }
}
