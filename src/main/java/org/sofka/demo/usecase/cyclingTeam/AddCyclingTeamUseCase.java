package org.sofka.demo.usecase.cyclingTeam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.demo.mappers.CyclingTeamMapper;
import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.model.CyclistDto;
import org.sofka.demo.repository.CyclingTeamRepository;
import org.sofka.demo.usecase.country.AddCountryUseCase;
import org.sofka.demo.usecase.cyclist.AddCyclistUseCase;
import org.sofka.demo.utilities.Util;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddCyclingTeamUseCase {
    private final CyclingTeamRepository cyclingTeamRepository;
    private final CyclingTeamMapper mapper;

    private final AddCyclistUseCase addCyclistUseCase;

    private final AddCountryUseCase addCountryUseCase;

    public Mono<CyclingTeamDto> apply(CyclingTeamDto cyclingTeamDto){
        log.info("\\n***** Saving cycling team *****\\n\"");

        return Flux.fromIterable(cyclingTeamDto.getCyclists())
                .flatMap(addCyclistUseCase::apply)
                .collectList()
                .map(cyclistDtoList ->{
                    cyclingTeamDto.setCyclists(cyclistDtoList);
                    return cyclingTeamDto;
                })
                .flatMap(cyclingTeamDto1 -> addCountryUseCase.apply(cyclingTeamDto1.getCountry()))
                .map(countryDto -> {
                    cyclingTeamDto.setCountry(countryDto);
                    return cyclingTeamDto;})
                .flatMap(cyclingTeamDto1 -> Util.save(cyclingTeamRepository,mapper).apply(cyclingTeamDto1));


    }

}
