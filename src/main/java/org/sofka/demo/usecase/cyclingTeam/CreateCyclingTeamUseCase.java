package org.sofka.demo.usecase.cyclingTeam;

import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.mappers.CyclingMapper;
import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.repository.CyclingTeamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CreateCyclingTeamUseCase {
    CyclingTeamRepository cyclingTeamRepository;
    CyclingMapper mapper;

    public CyclingTeamDto apply(CyclingTeamDto cyclingTeamDto){
        log.info("\\n***** Saving cycling team *****\\n\"");
        CyclingTeam cyclingTeamDtoToSave = cyclingTeamRepository.save(mapper.convertDtoToEntity().apply(cyclingTeamDto));
        return mapper.convertEntityToDto().apply(cyclingTeamDtoToSave);
    }

}
