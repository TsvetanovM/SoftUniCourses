package softuni.jsonprocessing.productsShop.services;

import softuni.jsonprocessing.productsShop.models.dtos.ProductSeed;

public interface ProductService {
    boolean productTableIsEmpty();

    void seedProducts(ProductSeed[] productSeeds);
}
