package fr.massora.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class DataDto{

 
	private Integer rank;
	
	private Integer points;
	
	private Integer weight;
	
	private Integer height;
	
	private Integer age;
	
	private List<Integer> last;
	

}
