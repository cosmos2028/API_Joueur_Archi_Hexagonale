package fr.massora.ports.spi;

import java.util.List;

import fr.massora.dto.PlayerDto;
import fr.massora.dto.PlayerStatsDto;

public interface PlayerPersistencePort {

   
    List<PlayerDto> getPlayers();

    PlayerDto getPlayerById(Integer playerId);
    
    PlayerStatsDto getPlayerStats ();

}
