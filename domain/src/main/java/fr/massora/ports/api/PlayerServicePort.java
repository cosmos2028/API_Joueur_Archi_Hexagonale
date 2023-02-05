package fr.massora.ports.api;

import java.util.List;

import fr.massora.dto.PlayerDto;
import fr.massora.dto.PlayerStatsDto;

public interface PlayerServicePort {

	List<PlayerDto> getPlayers();

    PlayerDto getPlayerById(Integer playerId);
    
    PlayerStatsDto getPlayerStats ();
}
