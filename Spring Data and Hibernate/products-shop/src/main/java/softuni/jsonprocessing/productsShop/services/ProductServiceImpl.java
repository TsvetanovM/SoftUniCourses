package softuni.jsonprocessing.productsShop.services;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.jsonprocessing.productsShop.models.dtos.ProductSeed;
import softuni.jsonprocessing.productsShop.models.entities.Category;
import softuni.jsonprocessing.productsShop.models.entities.Product;
import softuni.jsonprocessing.productsShop.models.entities.User;
import softuni.jsonprocessing.productsShop.repositories.CategoryRepository;
import softuni.jsonprocessing.productsShop.repositories.ProductRepository;
import softuni.jsonprocessing.productsShop.repositories.UserRepository;
import softuni.jsonprocessing.productsShop.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository, Gson gson, ModelMapper mapper, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean productTableIsEmpty() {
        return productRepository.count() == 0;
    }

    @Override
    public void seedProducts(ProductSeed[] productSeeds) {
        for (ProductSeed productSeed : productSeeds) {
            Set<ConstraintViolation<ProductSeed>> violations = validationUtil.getViolations(productSeed);

            if (!violations.isEmpty()) {
                violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
                continue;
            }

            Product product = mapper.map(productSeed, Product.class);

            User buyer = getRandomBuyer();
            product.setBuyer(buyer);

            User seller = getRandomSeller();
            product.setSeller(seller);

            Set<Category> categories = new HashSet<>();
            getRandomCategories(categories);
            product.setCategories(categories);

            productRepository.save(product);
        }
    }

    private User getRandomBuyer() {
        return userRepository.findById((long) (Math.random() * 100)).orElse(null);
    }

    private User getRandomSeller() {
        long sellerId = (long) ((Math.random() * (userRepository.count() - 1)) + 1);
        return userRepository.findById(sellerId).orElseThrow();
    }

    private void getRandomCategories(Set<Category> categories) {
        for (int i = 0; i < (int) ((Math.random() * (3 - 1)) + 1); i++) {
            long categoryId = (long) ((Math.random() * (categoryRepository.count() - 1)) + 1);
            Category category = categoryRepository.findById(categoryId).orElseThrow();
            categories.add(category);
        }
    }
}
