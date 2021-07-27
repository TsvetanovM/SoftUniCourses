package softuni.jsonprocessing.productsShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.jsonprocessing.productsShop.models.entities.Product;
import softuni.jsonprocessing.productsShop.models.entities.User;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u From User u WHERE (SELECT COUNT(p) FROM Product p WHERE " +
            "p.seller.id = u.id AND p.buyer IS NOT NULL) >= 1 ORDER BY " +
            "u.lastName, u.firstName")
    List<User> findAllWhoHaveSoldAtLeastOneProduct();
}
