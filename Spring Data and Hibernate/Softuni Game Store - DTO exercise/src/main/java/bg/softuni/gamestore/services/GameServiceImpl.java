package bg.softuni.gamestore.services;

import bg.softuni.gamestore.models.dto.GameAdd;
import bg.softuni.gamestore.models.entities.Game;
import bg.softuni.gamestore.repositories.GameRepository;
import bg.softuni.gamestore.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validation;
    private final ModelMapper mapperGameAdd;

    public GameServiceImpl(GameRepository gameRepository,@Qualifier("general") ModelMapper mapper,
                           ValidationUtil validation,@Qualifier("gameAdd") ModelMapper mapperGameAdd) {
        this.gameRepository = gameRepository;
        this.mapper = mapper;
        this.validation = validation;
        this.mapperGameAdd = mapperGameAdd;
    }

    @Override
    public void addGame(GameAdd gameAdd) {
        Set<ConstraintViolation<GameAdd>> violations = validation.violation(gameAdd);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = mapperGameAdd.map(gameAdd, Game.class);
        gameRepository.save(game);
        System.out.println("Added " + game.getTitle());
    }
}
