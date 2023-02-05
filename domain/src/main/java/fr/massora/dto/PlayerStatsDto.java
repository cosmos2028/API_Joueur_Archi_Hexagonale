package fr.massora.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatsDto {

	private Double imcAvgAllPlayers;
	private Double heightMedianAllPlayers;
	private String countryHighestWinRatio;
	
}
