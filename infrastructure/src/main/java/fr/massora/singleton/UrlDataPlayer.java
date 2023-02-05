package fr.massora.singleton;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * 
 * @author DLI
 *
 *Spring ne permet pas l' injection des varaibles static
 *
 *d'où l'implementaton de cette class pour contourner ce probleme.
 *
 */
@Component
public class UrlDataPlayer {

	 public static String urlDataPlayer;

	 	@Value("${data.player.url}")
	    public void setDatabase(String url) {
	 		urlDataPlayer = url;
	    }
	    
	
	public UrlDataPlayer() 
	{
		
		System.out.println("\nInjection de url dans variable urlDataPlayer");
	}
	
	
	

	
   
    
}
