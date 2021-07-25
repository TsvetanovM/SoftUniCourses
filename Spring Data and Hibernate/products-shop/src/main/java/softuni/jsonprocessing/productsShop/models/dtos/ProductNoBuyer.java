package softuni.jsonprocessing.productsShop.models.dtos;

import softuni.jsonprocessing.productsShop.models.entities.User;

import java.math.BigDecimal;

public class ProductNoBuyer {

    private String name;
    private BigDecimal price;
    private String seller;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
