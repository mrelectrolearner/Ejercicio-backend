package org.sofka.demo.usecase.cyclingTeam;

import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.mappers.CyclingMapper;
import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.repository.CyclingTeamRepository;
import org.sofka.demo.utilities.Util;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GetCyclingTeamUseCase {
    CyclingTeamRepository cyclingTeamRepository;
    CyclingMapper mapper;

    public List<CyclingTeamDto> apply(){
        List<CyclingTeam> cyclingTeams = Util.getListFromIterator(cyclingTeamRepository.findAll().iterator());
        log.info("\n***** Getting All cycling teams *****\n");
        return cyclingTeams
                .stream()
                .map(country ->mapper.convertEntityToDto().apply(country) )
                .collect(Collectors.toList());
    }
}
