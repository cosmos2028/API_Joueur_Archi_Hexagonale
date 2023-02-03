package fr.massora.service;

import java.util.List;

import fr.massora.dto.PlayerDto;
import fr.massora.ports.api.PlayerServicePort;
import fr.massora.ports.spi.PlayerPersistencePort;

public class PlayerServiceImpl implements PlayerServicePort {

    private PlayerPersistencePort playerPersistencePort;


    public PlayerServiceImpl(PlayerPersistencePort playerPersistencePort) {
        this.playerPersistencePort = playerPersistencePort;
    }
	@Override
	public List<PlayerDto> getPlayers() {
		return playerPersistencePort.getPlayers();
	}

	@Override
	public PlayerDto getPlayerById(Integer playerId) {
		return playerPersistencePort.getPlayerById(playerId);
	}
}
