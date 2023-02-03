package fr.massora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.massora.dto.PlayerDto;
import fr.massora.ports.api.PlayerServicePort;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerServicePort playerServicePort;


    @ApiOperation
    (value = "Get player BY id",
            notes = "Obtenir un joueur à partir de son identifiant ",
            response = PlayerDto.class)
    
    @GetMapping("/get/{id}")
    public PlayerDto getPlayerByID(@PathVariable Integer id) {
        return playerServicePort.getPlayerById(id);
    }

    @ApiOperation
    (value = "Get all player",
            notes = "Obtenir toute la liste des joueur existante du meilleur classé au moins bon",
            response = PlayerDto.class)
    @GetMapping("/getAllPlayers")
    public List<PlayerDto> getAllPlayers() {
        return playerServicePort.getPlayers();
    }

 
}
