package softuni.vehicles.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer passengerCapacity;
    private String airline;
    private String type;
    private String model;
    private BigDecimal price;
    private String fuelType;

    @ManyToOne (optional = false)
    @JoinColumn(name = "company_id",
    referencedColumnName = "id")
    private Company company;

    public Plane(Integer passengerCapacity, String airline, String type, String model, BigDecimal price, String fuelType) {
        this.passengerCapacity = passengerCapacity;
        this.airline = airline;
        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
    }

    public Plane() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
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

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }
}
