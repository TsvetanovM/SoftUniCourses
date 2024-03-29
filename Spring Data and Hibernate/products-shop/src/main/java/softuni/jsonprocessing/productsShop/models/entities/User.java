package softuni.jsonprocessing.productsShop.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private int age;
    private Set<Product> productsBought;
    private Set<Product> productsSold;
    private Set<User> friends;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER)
    public Set<Product> getProductsBought() {
        return productsBought;
    }

    public void setProductsBought(Set<Product> productsBought) {
        this.productsBought = productsBought;
    }

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    public Set<Product> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(Set<Product> productsForSale) {
        this.productsSold = productsForSale;
    }

    @ManyToMany(targetEntity = User.class)
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

}
