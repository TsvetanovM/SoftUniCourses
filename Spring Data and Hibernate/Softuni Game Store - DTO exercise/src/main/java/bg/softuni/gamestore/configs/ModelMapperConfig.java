package bg.softuni.gamestore.configs;

import bg.softuni.gamestore.models.dto.GameAdd;
import bg.softuni.gamestore.models.entities.Game;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    @Qualifier(value = "general")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    @Qualifier(value = "gameAdd")
    public ModelMapper modelMapperGameAdd() {
        var mapper = new org.modelmapper.ModelMapper();
        TypeMap<GameAdd, Game> typeMap = mapper.createTypeMap(GameAdd.class, Game.class);
        typeMap.addMappings(mapping -> {
            mapping.map(gameAdd -> gameAdd.getTrailer()
                    .substring(gameAdd.getTrailer().length() - 11), Game::setTrailer);
        });

        return mapper;
    }

}
