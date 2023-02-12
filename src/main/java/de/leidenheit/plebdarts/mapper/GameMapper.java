package de.leidenheit.plebdarts.mapper;

import de.leidenheit.plebdarts.resource.api.game.GameReadResource;
import de.leidenheit.plebdarts.resource.entity.game.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {

    GameMapper MAPPER = Mappers.getMapper(GameMapper.class);

    GameReadResource mapGameToGameReadResource(Game game);
}
