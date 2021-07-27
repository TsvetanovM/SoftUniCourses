package softuni.jsonprocessing.productsShop.services;

import softuni.jsonprocessing.productsShop.models.dtos.CategoriesSeed;
import softuni.jsonprocessing.productsShop.models.dtos.CategorySeed;

public interface CategoryService {
    boolean categoryTableIsEmpty();

    void seedCategories(CategorySeed[] categorySeeds);

    void seedCategories(CategoriesSeed categoriesSeed);
}
