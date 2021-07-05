package softuni.vehicles.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "cars")
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String model;
    private BigDecimal price;
    private String fuelType;
    private Integer seats;
    @OneToOne(optional = false)
    @JoinColumn(name = "plateNumber_id", referencedColumnName = "id")
    private Plate_number plateNumber;

    public Car(String type, String model, BigDecimal price, String fuelType, Integer seats) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
        this.seats = seats;
    }

    public Car() { }

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

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Plate_number getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(Plate_number plateNumber) {
        this.plateNumber = plateNumber;
    }
}
