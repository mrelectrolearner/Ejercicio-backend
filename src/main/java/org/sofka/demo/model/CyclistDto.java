package org.sofka.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sofka.demo.domain.Country;
import org.sofka.demo.domain.CyclingTeam;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CyclistDto {

    private String id;

    private String fullName;

    private String competitorNumber;

    private CountryDto originCountry;

}
