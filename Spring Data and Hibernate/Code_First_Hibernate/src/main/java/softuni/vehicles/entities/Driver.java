package softuni.vehicles.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String full_name;
    @ManyToMany (mappedBy = "drivers")
    private Set<Truck> trucks = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Set<Truck> getTrucks() {
        return trucks;
    }

    public void setTruck(Truck truck) {
        this.trucks.add(truck);
    }
}
