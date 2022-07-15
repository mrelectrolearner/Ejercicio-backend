package org.sofka.demo.usecase.cyclingTeam;

import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.mappers.CyclingMapper;
import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.repository.CyclingTeamRepository;
import org.springframework.stereotype.Service;

@Service
public class GetCyclingTeamByTeamCodeUseCase {
    CyclingTeamRepository cyclingTeamRepository;
    CyclingMapper mapper;

    public CyclingTeamDto apply(String teamCode){
        CyclingTeam cyclingTeamFound = cyclingTeamRepository.findCyclingTeamByTeamCode(teamCode).orElse(new CyclingTeam());
        return mapper.convertEntityToDto().apply(cyclingTeamFound);

    }
}
