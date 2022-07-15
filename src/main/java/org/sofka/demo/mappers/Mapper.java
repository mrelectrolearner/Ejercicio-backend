package org.sofka.demo.mappers;

import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.domain.Cyclist;
import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.model.CyclistDto;

import java.util.function.Function;

public interface Mapper<E,D> {
    Function<D, E> convertDtoToEntity();
    Function<E, D> convertEntityToDto();
}
