package bg.softuni.gamestore.repositories;

import bg.softuni.gamestore.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
