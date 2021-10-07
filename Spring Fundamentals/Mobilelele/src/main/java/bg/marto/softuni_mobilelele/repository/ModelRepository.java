package bg.marto.softuni_mobilelele.repository;

import bg.marto.softuni_mobilelele.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
