package bg.marto.softuni_mobilelele.repository;

import bg.marto.softuni_mobilelele.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
