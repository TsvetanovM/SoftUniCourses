package softuni.vehicles.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "Plane")
public class Plane extends Vehicle{

    private Integer passengerCapacity;
    private String airline;

    public Plane(String type, String model, BigDecimal price, String fuelType, Integer passengerCapacity, String airline) {
        super(type, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
        this.airline = airline;
    }

    public Plane() { }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
