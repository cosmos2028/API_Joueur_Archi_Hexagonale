package fr.massora.ports.api;

import java.util.List;

import fr.massora.dto.PlayerDto;

public interface PlayerServicePort {

	List<PlayerDto> getPlayers();

    PlayerDto getPlayerById(Integer playerId);
}
