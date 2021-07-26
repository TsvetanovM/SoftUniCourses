package softuni.jsonprocessing.productsShop.models.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CategorySeed {

    @Expose
    @NotNull
    @Size(min = 3, max = 15, message = "Category name must be between 3 and 15 characters!")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
