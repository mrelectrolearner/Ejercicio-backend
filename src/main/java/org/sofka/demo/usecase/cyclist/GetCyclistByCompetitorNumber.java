package org.sofka.demo.usecase.cyclist;

import lombok.RequiredArgsConstructor;
import org.sofka.demo.domain.Cyclist;
import org.sofka.demo.mappers.CyclistMapper;
import org.sofka.demo.model.CyclistDto;
import org.sofka.demo.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetCyclistByCompetitorNumber {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Mono<CyclistDto> apply(String competitorNumber ){
        return cyclistRepository
                .findCyclistByCompetitorNumber(competitorNumber)
                .map(cyclist->cyclistMapper
                        .convertEntityToDto()
                        .apply(cyclist));
    }
}
