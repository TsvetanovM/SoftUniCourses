package sales.entities;

import Base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

//@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;
    private int quantity;
    private BigDecimal price;
    @OneToMany(mappedBy = "product")
    private Set<Sale> sales;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
