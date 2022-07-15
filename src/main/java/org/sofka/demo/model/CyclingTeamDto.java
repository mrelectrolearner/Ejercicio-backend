package org.sofka.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sofka.demo.domain.Country;
import org.sofka.demo.domain.Cyclist;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CyclingTeamDto {
    private int id;
    private String name;
    private String teamCode;
    private Country country;
    private List<Cyclist> cyclists;
}
