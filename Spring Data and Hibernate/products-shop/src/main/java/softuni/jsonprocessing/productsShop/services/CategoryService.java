package softuni.jsonprocessing.productsShop.services;

import softuni.jsonprocessing.productsShop.models.dtos.CategorySeed;

public interface CategoryService {
    boolean categoryTableIsEmpty();

    void seedCategories(CategorySeed[] categorySeeds);
}
