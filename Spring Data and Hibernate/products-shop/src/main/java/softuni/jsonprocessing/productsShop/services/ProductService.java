package softuni.jsonprocessing.productsShop.services;

import softuni.jsonprocessing.productsShop.models.dtos.ProductNoBuyer;
import softuni.jsonprocessing.productsShop.models.dtos.ProductSeed;
import softuni.jsonprocessing.productsShop.models.dtos.ProductsSeed;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    boolean productTableIsEmpty();

    void seedProducts(ProductSeed[] productSeeds);

    void assignCategories();

    List<ProductNoBuyer> exportProductsInAPriceRangeWithNoBuyer(BigDecimal lowPrice, BigDecimal highPrice);

    void seedProducts(ProductsSeed productsSeed);
}
