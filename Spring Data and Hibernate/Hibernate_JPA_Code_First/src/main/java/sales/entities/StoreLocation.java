package sales.entities;

import Base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store_location")
public class StoreLocation extends BaseEntity {

    @Column(name = "location_name")
    private String locationName;
    @OneToMany(mappedBy = "storeLocation")
    private Set<Sale> sales;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
