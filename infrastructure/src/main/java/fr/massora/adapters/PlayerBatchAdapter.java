package fr.massora.adapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.massora.dto.PlayerDto;
import fr.massora.dto.PlayerStatsDto;
import fr.massora.entity.Player;
import fr.massora.entity.PlayerStats;
import fr.massora.mappers.PlayerMapper;
import fr.massora.ports.spi.PlayerPersistencePort;
import fr.massora.singleton.SingletonConnectionApiJson;

@Service
public class PlayerBatchAdapter implements PlayerPersistencePort {
	 
	@Override
	public List<PlayerDto> getPlayers() {
		
		List<PlayerDto> playerListToPlayerDtoList = null;
        try {
            
            List<Player> playerList = SingletonConnectionApiJson.getDataJsonFromApi();
            
            //trier les joueurs  du meilleur classé au moins bon
            List<Player> sortedPlayers = playerList.stream()
                    .sorted(Comparator.comparing(player->player.getData().getRank()))
                    .collect(Collectors.toList());

             playerListToPlayerDtoList = PlayerMapper.INSTANCE.PlayerListToPlayerDtoList(sortedPlayers);
             
        } catch (Exception e) {
            e.getStackTrace();
        }
        return playerListToPlayerDtoList;
	}

	@Override
	public PlayerDto getPlayerById(Integer playerId) {
		
		 PlayerDto playerByIdDto=null;
		
        try {
        	List<Player> playerList = SingletonConnectionApiJson.getDataJsonFromApi();
        	
           //s'il existe retourne le joueur avec l 'id propose
            
        	Player playerById   = playerList.stream().
        		    filter(player -> player.getId()== playerId).
        		    findFirst().get();
        	
        	playerByIdDto = PlayerMapper.INSTANCE.playerToPlayerDto(playerById);
        	
        } catch (Exception e) {
            e.getStackTrace();
        }
        
        return playerByIdDto;
	}

	@Override
	public PlayerStatsDto getPlayerStats() {
		
		PlayerStatsDto  playerStatsDto=null;
    	List<Player> playerList = SingletonConnectionApiJson.getDataJsonFromApi();

    	// IMC = poids en kg / taille² en m.par contre les données JSON sont en g et cm
    	Double imcAvgAllPlayers = 
    			playerList.stream()
                .mapToDouble(player->(player.getData().getWeight())*0.001 /  Math.pow((player.getData().getHeight())* 0.01 , 2) )
                .average().orElse(0);
    			
    	System.out.println("\nIMC :"+ imcAvgAllPlayers);
    	System.out.println("\nIMC arrondi 2 chiiffres apres la virgule :"+ Math.round(imcAvgAllPlayers*100.0)/100.0);
    	
    	//Taille médian des joueurs en metre
    	// 1) recuperer la liste triée de la taille des joueurs
    	List<Integer> heighintegersList = playerList.stream()
    			.map(player -> (player.getData().getHeight()))
    			.sorted().collect(Collectors.toList());
    	 
    	// 2) trouver la mediane
    	int size=heighintegersList.size();
        int middle=size/2;
        int resMedian=0;
        
        if( !(heighintegersList.isEmpty()) )
     	{
        	
        	  if((size%2)==0)                                       
              {
              	resMedian=(heighintegersList.get(middle)+heighintegersList.get(middle+1))/2;
              }
              else                                                
              {
              	resMedian= heighintegersList.get(middle);
              }
     	}
    	System.out.println("\n heighintegersList : "+heighintegersList);
    	System.out.println("\n median en metre : "+resMedian * 0.01);
    	
    	//Pays avec le plus gros ratio de victoire
    	List<Player> playerListWithSumLast = new ArrayList<Player>();
    	//1 etape faire la somme des victoire et stoker dans l'object
    	 playerList.forEach(player -> 
         {
         	if( !(player.getData().getLast().isEmpty()) )
         	{
         		Integer sumLast = player.getData().getLast().stream()
         				  .reduce(0, (a, b) -> a + b);
         		
         		List<Integer> integerLast = Arrays.asList(sumLast);
         		player.getData().setLast(integerLast);
         		
         		playerListWithSumLast.add(player);
         		
         		
         	}
         	
         });
    	//2 etape get a player with the maximum last (victoire )
    	 Player maxValueLastPlayer  = playerListWithSumLast.stream()
    	                 .collect(Collectors.maxBy(
    	                 Comparator.comparing(player->player.getData().getLast().get(0))))
    	                 .get();
    	 //3 get code pays
    	 System.out.println("\ncode du pays avec le plus de victoire :"+maxValueLastPlayer.getCountry().getCode());
    	 double roundIMC = Math.round(imcAvgAllPlayers*100.0)/100.0;
    	 PlayerStats playerStats = new PlayerStats(roundIMC,resMedian * 0.01,maxValueLastPlayer.getCountry().getCode());
    	 playerStatsDto = PlayerMapper.INSTANCE.playerStatsToPlayerStatsDto(playerStats);
    			 
		return playerStatsDto;
	}
}
