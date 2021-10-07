package bg.marto.softuni_mobilelele.repository;

import bg.marto.softuni_mobilelele.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
