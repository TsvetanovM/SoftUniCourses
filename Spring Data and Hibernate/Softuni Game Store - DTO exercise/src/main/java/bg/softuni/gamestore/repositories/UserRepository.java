package bg.softuni.gamestore.repositories;

import bg.softuni.gamestore.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
