package softuni.jsonprocessing.productsShop;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.jsonprocessing.productsShop.models.dtos.CategorySeed;
import softuni.jsonprocessing.productsShop.models.dtos.ProductNoBuyer;
import softuni.jsonprocessing.productsShop.models.dtos.ProductSeed;
import softuni.jsonprocessing.productsShop.models.dtos.UserSeed;
import softuni.jsonprocessing.productsShop.services.CategoryService;
import softuni.jsonprocessing.productsShop.services.ProductService;
import softuni.jsonprocessing.productsShop.services.UserService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Controller
public class ConsoleRunner implements CommandLineRunner {

    private static final String BASE_INPUT_PATH = "./src/main/resources/json/";
    private static final String OUTPUT_PATH = "./src/main/resources/jsonExports/";
    private static final String PRODUCTS_NO_BUYER_PATH = "products-no-buyer.json";
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final Gson gson;

    public ConsoleRunner(UserService userService, ProductService productService, CategoryService categoryService, Gson gson) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
//            seedData();
            query1();
//            assignCategoriesToProducts();
        } catch (FileNotFoundException e) {
            System.out.println("No such file found in the provided path!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void query1() throws IOException {
        List<ProductNoBuyer> products = productService
                .exportProductsInAPriceRangeWithNoBuyer(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));
        String toJson = gson.toJson(products);
        writeToJsonFile(OUTPUT_PATH + PRODUCTS_NO_BUYER_PATH, toJson);
    }

    private void writeToJsonFile(String path, String toJson) throws IOException {
        Files.write(Path.of(path), Collections.singleton(toJson));
    }

    private void assignCategoriesToProducts() {
        productService.assignCategories();
    }

    private void seedData() throws FileNotFoundException {
        seedUserData();
        seedCategoryData();
        seedProductData();
    }

    private void seedCategoryData() throws FileNotFoundException {
        if (categoryService.categoryTableIsEmpty()) {
            CategorySeed[] categorySeeds = gson.fromJson(new FileReader(BASE_INPUT_PATH + "categories.json"), CategorySeed[].class);

            categoryService.seedCategories(categorySeeds);
        }
    }

    private void seedProductData() throws FileNotFoundException {
        if (productService.productTableIsEmpty()) {
            ProductSeed[] productSeeds = gson.fromJson(new FileReader(BASE_INPUT_PATH + "products.json"), ProductSeed[].class);
            productService.seedProducts(productSeeds);
        }
    }

    private void seedUserData() throws FileNotFoundException {
        if (userService.userTableIsEmpty()) {
            UserSeed[] userSeeds = gson.fromJson(new FileReader(BASE_INPUT_PATH + "users.json"), UserSeed[].class);
            userService.seedUsers(userSeeds);
        }
    }
}
