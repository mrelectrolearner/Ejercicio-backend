package org.sofka.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.domain.Cyclist;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private int id;

    private String name;
    private String code;
    private List<CyclingTeam> cyclingTeams;
    private List<Cyclist> cyclists;
}
