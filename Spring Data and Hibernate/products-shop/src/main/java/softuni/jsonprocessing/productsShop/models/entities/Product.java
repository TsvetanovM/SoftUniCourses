package softuni.jsonprocessing.productsShop.models.entities;

import softuni.jsonprocessing.productsShop.models.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;
    private BigDecimal price;
    private User buyer;
    private User seller;
    private Set<Category> categories;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyerId) {
        this.buyer = buyerId;
    }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    public User getSeller() {
        return seller;
    }

    public void setSeller(User sellerId) {
        this.seller = sellerId;
    }

    @ManyToMany
    @JoinTable(name = "products_categories",
    joinColumns = @JoinColumn (name = "category_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
