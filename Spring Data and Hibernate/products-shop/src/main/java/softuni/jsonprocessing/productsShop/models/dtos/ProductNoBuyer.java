package softuni.jsonprocessing.productsShop.models.dtos;

import com.google.gson.annotations.Expose;
import softuni.jsonprocessing.productsShop.models.entities.User;

import java.math.BigDecimal;

public class ProductNoBuyer {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String sellerInfo;

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

    public String getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(String sellerInfo) {
        this.sellerInfo = sellerInfo;
    }
}
