package org.sofka.demo.usecase.cyclist;

import lombok.RequiredArgsConstructor;
import org.sofka.demo.domain.Cyclist;
import org.sofka.demo.mappers.CyclistMapper;
import org.sofka.demo.model.CyclistDto;
import org.sofka.demo.repository.CyclistRepository;
import org.sofka.demo.utilities.Util;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class GetAllCyclistsUseCase {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Flux<CyclistDto> apply(){
        return cyclistRepository
                .findAll()
                .map(cyclist -> cyclistMapper
                        .convertEntityToDto()
                        .apply(cyclist));
    }
}
