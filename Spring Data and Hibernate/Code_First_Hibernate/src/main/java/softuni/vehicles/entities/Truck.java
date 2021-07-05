package softuni.vehicles.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "Truck")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String model;
    private BigDecimal price;
    private String fuelType;
    private Double loadCapacity;
    @ManyToMany
    @JoinTable(name = "drivers_trucks",
    joinColumns = @JoinColumn(name = "truck_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"))
    private Set<Driver> drivers;

    public Truck() { }

    public Truck(String type, String model, BigDecimal price, String fuelType, Double loadCapacity) {

        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
        this.loadCapacity = loadCapacity;
        this.drivers = new HashSet<Driver>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDriver(Driver driver) {
        this.drivers.add(driver);
    }
}
