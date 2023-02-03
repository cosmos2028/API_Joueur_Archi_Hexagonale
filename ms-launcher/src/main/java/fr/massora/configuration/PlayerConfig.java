package fr.massora.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.massora.adapters.PlayerBatchAdapter;
import fr.massora.ports.api.PlayerServicePort;
import fr.massora.ports.spi.PlayerPersistencePort;
import fr.massora.service.PlayerServiceImpl;

@Configuration
public class PlayerConfig {

    @Bean
    public PlayerPersistencePort playerPersistence(){
        return new PlayerBatchAdapter();
    }

    @Bean
    public PlayerServicePort playerService(){
        return new PlayerServiceImpl(playerPersistence());
    }
}