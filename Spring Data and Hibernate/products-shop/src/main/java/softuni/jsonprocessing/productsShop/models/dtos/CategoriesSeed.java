package softuni.jsonprocessing.productsShop.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesSeed {

    @XmlElement(name = "category")
    private List<CategorySeed> categories;

    public List<CategorySeed> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorySeed> categories) {
        this.categories = categories;
    }
}
