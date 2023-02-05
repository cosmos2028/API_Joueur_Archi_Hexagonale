package fr.massora.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import fr.massora.dto.PlayerDto;
import fr.massora.dto.PlayerStatsDto;
import fr.massora.entity.Player;
import fr.massora.entity.PlayerStats;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "countryDto", source = "country")
    @Mapping(target = "dataDto", source = "data")
    PlayerDto playerToPlayerDto(Player player);

    @Mapping(target = "country", source = "countryDto")
    @Mapping(target = "data", source = "dataDto")
    Player PlayerDtoToPlayer(PlayerDto playerDto);
    List<PlayerDto> PlayerListToPlayerDtoList(List<Player> playerList);
    List<Player> PlayerDtoListToPlayerList(List<PlayerDto> playerDtoList);
    
 
    PlayerStatsDto  playerStatsToPlayerStatsDto(PlayerStats playerStats);
    PlayerStats PlayerStatsDtoToplayerStats(PlayerStatsDto playerStatsDto );
    
    List<PlayerStatsDto> playerStatsListToPlayerStatsDtoList(List<PlayerStats> playerStatsList);
    List<PlayerStats> PlayerStatsDtoListToPlayerStatsList (List<PlayerStatsDto> playerStatsDtoList);
    
}
