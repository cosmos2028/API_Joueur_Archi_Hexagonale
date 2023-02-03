package fr.massora.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class Player {

	private Integer id;
	
	private String firstname;
	
	private  String lastname;
	
	private String shortname;
	
	private String sex;
	
	
	private Country country;
	
	private String picture;
	

	private Data data;
	
}
