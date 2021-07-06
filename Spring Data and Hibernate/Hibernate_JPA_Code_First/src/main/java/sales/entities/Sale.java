package sales.entities;

import Base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @ManyToOne
    private Product product;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private StoreLocation storeLocation;
    private LocalDateTime date;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
