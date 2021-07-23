package softuni.jsonprocessing.productsShop.models.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategorySeed {

    @NotNull
    @Size(min = 3, max = 15, message = "Category name must be between 3 and 15 characters!")
    private String name;
}
