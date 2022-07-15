package org.sofka.demo.usecase.cyclist;

import lombok.RequiredArgsConstructor;
import org.sofka.demo.domain.Cyclist;
import org.sofka.demo.mappers.CyclistMapper;
import org.sofka.demo.model.CyclistDto;
import org.sofka.demo.repository.CyclistRepository;
import org.sofka.demo.utilities.Util;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AddCyclistUseCase {
    public final CyclistRepository cyclistRepository;
    public final CyclistMapper cyclistMapper;

    public Mono<CyclistDto> apply(CyclistDto newCyclist){
        return Util.save(cyclistRepository,cyclistMapper).apply(newCyclist);
    }
}
