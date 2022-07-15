package org.sofka.demo.usecase.cyclist;

import lombok.RequiredArgsConstructor;
import org.sofka.demo.domain.Cyclist;
import org.sofka.demo.mappers.CyclistMapper;
import org.sofka.demo.model.CyclistDto;
import org.sofka.demo.repository.CyclistRepository;
import org.sofka.demo.utilities.Util;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class GetAllCyclistsUseCase {
    CyclistRepository cyclistRepository;
    CyclistMapper cyclistMapper;

    public List<CyclistDto> apply(){
        List<Cyclist> cyclists = Util.getListFromIterator(cyclistRepository.findAll().iterator());
        return cyclists
                .stream()
                .map(cyclist -> cyclistMapper.convertEntityToDto().apply(cyclist))
                .collect(Collectors.toList());

    }
}
