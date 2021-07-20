package bg.softuni.gamestore.repositories;

import bg.softuni.gamestore.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
