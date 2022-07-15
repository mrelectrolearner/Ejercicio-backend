package org.sofka.demo.model;


import lombok.*;
import org.sofka.demo.domain.CyclingTeam;
import org.sofka.demo.domain.Cyclist;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {

    private String id;
    private String name;
    private String code;

}
