package softuni.jsonprocessing.productsShop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.jsonprocessing.productsShop.models.dtos.ProductNoBuyer;
import softuni.jsonprocessing.productsShop.models.dtos.ProductSeed;
import softuni.jsonprocessing.productsShop.models.dtos.ProductsNoBuyer;
import softuni.jsonprocessing.productsShop.models.dtos.ProductsSeed;
import softuni.jsonprocessing.productsShop.models.entities.Category;
import softuni.jsonprocessing.productsShop.models.entities.Product;
import softuni.jsonprocessing.productsShop.models.entities.User;
import softuni.jsonprocessing.productsShop.repositories.CategoryRepository;
import softuni.jsonprocessing.productsShop.repositories.ProductRepository;
import softuni.jsonprocessing.productsShop.repositories.UserRepository;
import softuni.jsonprocessing.productsShop.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper generalMapper;
    private final ValidationUtil validationUtil;

    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository,
                              CategoryRepository categoryRepository, @Qualifier("General") ModelMapper generalMapper,
                              ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.generalMapper = generalMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean productTableIsEmpty() {
        return productRepository.count() == 0;
    }

    @Override
    public void seedProducts(ProductSeed[] productSeeds) {
        for (ProductSeed productSeed : productSeeds) {
            validateProductAndPersist(productSeed);
        }
    }

    @Override
    public void assignCategories() {
        List<Product> all = productRepository.findAll();

        for (Product product : all) {
            Set<Category> categories = new HashSet<>();
            getRandomCategories(categories);
            product.setCategories(categories);
            productRepository.save(product);
        }
    }

    @Override
    public ProductsNoBuyer exportProductsInAPriceRangeWithNoBuyer(BigDecimal lowPrice, BigDecimal highPrice) {
        List<ProductNoBuyer> productNoBuyers = productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowPrice, highPrice)
                .stream()
                .map(product -> {
                    ProductNoBuyer productNoBuyer = generalMapper.map(product, ProductNoBuyer.class);
                    productNoBuyer.setSellerInfo(String.format("%s %s",
                            product.getSeller().getFirstName(), product.getSeller().getLastName()));
                    return productNoBuyer;
                })
                .collect(Collectors.toList());

        ProductsNoBuyer productsNoBuyer = new ProductsNoBuyer();
        productsNoBuyer.setProducts(productNoBuyers);
        return productsNoBuyer;
    }

    @Override
    public void seedProducts(ProductsSeed productsSeed) {
        for (ProductSeed productSeed : productsSeed.getProducts()) {
            validateProductAndPersist(productSeed);
        }
    }

    private void validateProductAndPersist(ProductSeed productSeed) {
        Set<ConstraintViolation<ProductSeed>> violations = validationUtil.getViolations(productSeed);

        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }

        Product product = generalMapper.map(productSeed, Product.class);

        User buyer = getRandomBuyer();
        product.setBuyer(buyer);

        User seller = getRandomSeller();
        product.setSeller(seller);

        productRepository.save(product);
    }

    private User getRandomBuyer() {
        return userRepository.findById((long) (Math.random() * 100)).orElse(null);
    }

    private User getRandomSeller() {
        long sellerId = ThreadLocalRandom.current().nextInt(1, 57);
        return userRepository.findById(sellerId).orElseThrow();
    }

    private void getRandomCategories(Set<Category> categories) {
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1, 4); i++) {
            long categoryId = ThreadLocalRandom.current().nextInt(1, 12);
            Category category = categoryRepository.findById(categoryId).orElseThrow();
            categories.add(category);
        }
    }
}
