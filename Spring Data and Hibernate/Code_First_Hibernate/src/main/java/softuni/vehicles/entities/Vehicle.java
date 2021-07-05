package softuni.vehicles.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {

    public Vehicle(String type, String model, BigDecimal price, String fuelType) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String type;
    private String model;
    private BigDecimal price;
    private String fuelType;

    public Vehicle() {

    }
}
