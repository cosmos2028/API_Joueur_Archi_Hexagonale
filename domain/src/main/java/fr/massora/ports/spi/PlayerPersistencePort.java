package fr.massora.ports.spi;

import java.util.List;

import fr.massora.dto.PlayerDto;

public interface PlayerPersistencePort {

   
    List<PlayerDto> getPlayers();

    PlayerDto getPlayerById(Integer playerId);

}
