package fr.massora.singleton;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.massora.entity.Player;
/**
 * 
 * @author DLI
 * 
 * Pour eviter de faire des appels API distant pour recuperer les données JSON à chaque 
 * exécution d'un service. 
 * j'ai mis en place un singleton qui fait un restemplate
 * une seule fois pour stocker les données en memoire.
 * 
 * Et maintenant  les prochiane reqquete ou appel de service vont directement utiliser
 * les données stoker en memoire au lieu de faire encore get api du json distant.
 * 
 *
 */
public class SingletonConnectionApiJson {

	private static  List<Player>  playerList;

	static {
		 try {
			 
		        RestTemplate restTemplate = new RestTemplate();
		        final String response = restTemplate.getForObject(UrlDataPlayer.urlDataPlayer, String.class);
		        System.out.println("\nCreation d'une connection vers l'api");
		        
		        ObjectMapper oMapper = new ObjectMapper();
		        // convert JSON array to List of objects

		        JsonNode jsonNodePlayer = oMapper.readTree(response);

		        System.out.println("\n Data : "+jsonNodePlayer.get("players").toString());
		        
		        playerList = Arrays.asList(oMapper.readValue(jsonNodePlayer.get("players").toString(), Player[].class));
		        
		    } catch (JsonProcessingException e) {
		        e.getStackTrace();
		    }
	}

    
	public static List<Player>  getDataJsonFromApi ()
	{
		return playerList;
	}
}
