package org.sofka.demo.domain;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@Document(collection = "cyclist")
public class Cyclist {
	@Id
	private String id;

	private String fullName;

	private String competitorNumber;

	private Country originCountry;

	private CyclingTeam cyclingTeam;
}
