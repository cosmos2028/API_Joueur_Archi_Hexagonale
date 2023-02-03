package fr.massora.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class PlayerDto {

	private Integer id;
	
	private String firstname;
	
	private  String lastname;
	
	private String shortname;
	
	private String sex;
	
	@JsonProperty("country")
	private CountryDto countryDto;
	
	private String picture;
	
	@JsonProperty("data")
	private DataDto dataDto;
	
}
