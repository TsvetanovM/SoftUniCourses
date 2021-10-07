package bg.marto.softuni_mobilelele.repository;

import bg.marto.softuni_mobilelele.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
