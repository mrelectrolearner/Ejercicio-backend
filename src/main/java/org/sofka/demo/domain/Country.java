package org.sofka.demo.domain;

import java.util.List;



import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sofka.demo.model.CyclingTeamDto;
import org.sofka.demo.model.CyclistDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@Document(collection = "country")
public class Country {
	@Id
	private String id;

	private String name;

	private String code;
	private List<CyclingTeam> cyclingTeams;
	private List<Cyclist> cyclists;

}
