package softuni.jsonprocessing.productsShop.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsNoBuyer {

    @XmlElement(name = "product")
    private List<ProductNoBuyer> products;

    public List<ProductNoBuyer> getProducts() {
        return products;
    }

    public void setProducts(List<ProductNoBuyer> products) {
        this.products = products;
    }
}
