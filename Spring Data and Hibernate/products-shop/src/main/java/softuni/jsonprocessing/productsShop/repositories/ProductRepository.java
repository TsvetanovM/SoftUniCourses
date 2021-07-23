package softuni.jsonprocessing.productsShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.jsonprocessing.productsShop.models.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
