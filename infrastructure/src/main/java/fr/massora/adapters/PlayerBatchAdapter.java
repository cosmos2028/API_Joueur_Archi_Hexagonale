package fr.massora.adapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.massora.dto.PlayerDto;
import fr.massora.entity.Player;
import fr.massora.mappers.PlayerMapper;
import fr.massora.ports.spi.PlayerPersistencePort;

@Service
public class PlayerBatchAdapter implements PlayerPersistencePort {


	 @Value("${data.player.url}")
	    private String urlDataPlayer;
	 
	 
	@Override
	public List<PlayerDto> getPlayers() {
		
		List<PlayerDto> playerListToPlayerDtoList = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            final String response = restTemplate.getForObject(urlDataPlayer, String.class);
            ObjectMapper oMapper = new ObjectMapper();
            // convert JSON array to List of objects

            JsonNode jsonNodePlayer = oMapper.readTree(response);

            System.out.println(jsonNodePlayer.get("players").toString());
            
            List<Player> playerList = Arrays.asList(oMapper.readValue(jsonNodePlayer.get("players").toString(), Player[].class));
            
            //System.out.println("\n"+playerList);
            
            //trier les joueurs  du meilleur classé au moins bon
            List<Player> sortedPlayers = playerList.stream()
                    .sorted(Comparator.comparing(player->player.getData().getRank()))
                    .collect(Collectors.toList());
            
            //System.out.println("\ntrie "+sortedPlayers);

             playerListToPlayerDtoList = PlayerMapper.INSTANCE.PlayerListToPlayerDtoList(sortedPlayers);
        } catch (JsonProcessingException e) {
            e.getStackTrace();
        }
        return playerListToPlayerDtoList;
	}

	@Override
	public PlayerDto getPlayerById(Integer playerId) {
		
		 PlayerDto playerToPlayerDto = null;
		 List<PlayerDto> playerListToPlayerDtoList = new ArrayList<PlayerDto>();
		
        try {
            RestTemplate restTemplate = new RestTemplate();
            final String response = restTemplate.getForObject(urlDataPlayer, String.class);
            ObjectMapper oMapper = new ObjectMapper();
            // convert JSON array to List of objects

            JsonNode jsonNodePlayer = oMapper.readTree(response);

            System.out.println(jsonNodePlayer.get("players").toString());
            
            List<Player> playerList = Arrays.asList(oMapper.readValue(jsonNodePlayer.get("players").toString(), Player[].class));
            
           //s'il existe retourne le joueur avec l 'id prpose
            
            playerList.forEach(player -> 
            
            {
            	if(player.getId()== playerId)
            	{
            		//System.out.println(player);
            		
            		PlayerDto playerToPlayerDtoLamda = PlayerMapper.INSTANCE.playerToPlayerDto(player);

            		playerListToPlayerDtoList.add(playerToPlayerDtoLamda);
            		//System.out.println(playerToPlayerDtoLamda);
            	}
            	
            });
            

        } catch (JsonProcessingException e) {
            e.getStackTrace();
        }
        
        if(null!=playerListToPlayerDtoList.get(0))
        {
        	playerToPlayerDto = playerListToPlayerDtoList.get(0);
        }
        
        return playerToPlayerDto;
	}
}
