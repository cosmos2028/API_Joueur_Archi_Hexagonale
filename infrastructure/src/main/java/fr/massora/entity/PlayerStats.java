package fr.massora.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStats {

	private Double imcAvgAllPlayers;
	private Double heightMedianAllPlayers;
	private String countryHighestWinRatio;
	
}
