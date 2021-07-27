package softuni.jsonprocessing.productsShop.models.dtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductNoBuyer {

    @XmlAttribute
    @Expose
    private String name;
    @XmlAttribute
    @Expose
    private BigDecimal price;
    @XmlAttribute(name = "seller")
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
