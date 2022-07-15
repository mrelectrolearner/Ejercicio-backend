package org.sofka.demo.domain;

import java.util.List;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;


@Data
@NoArgsConstructor
@Document(collection = "cycling-team")
public class CyclingTeam {
	@Id
	private String id;

	private String name;
	

	private String teamCode;

	private Country country;

	private List<Cyclist> cyclists;
}
