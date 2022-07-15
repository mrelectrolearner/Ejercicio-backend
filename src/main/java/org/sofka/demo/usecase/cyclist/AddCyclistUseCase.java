package org.sofka.demo.usecase.cyclist;

import lombok.RequiredArgsConstructor;
import org.sofka.demo.domain.Cyclist;
import org.sofka.demo.mappers.CyclistMapper;
import org.sofka.demo.model.CyclistDto;
import org.sofka.demo.repository.CyclistRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddCyclistUseCase {
    CyclistRepository cyclistRepository;
    CyclistMapper cyclistMapper;

    public CyclistDto apply(CyclistDto newCyclist){
        Cyclist cyclistSaved=cyclistRepository.save(cyclistMapper.convertDtoToEntity().apply(newCyclist));
        return cyclistMapper.convertEntityToDto().apply(cyclistSaved);
    }
}
