package softuni.jsonprocessing.productsShop;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.jsonprocessing.productsShop.exceptions.FileCouldNotBeSerialized;
import softuni.jsonprocessing.productsShop.models.dtos.*;
import softuni.jsonprocessing.productsShop.services.CategoryService;
import softuni.jsonprocessing.productsShop.services.ProductService;
import softuni.jsonprocessing.productsShop.services.UserService;
import softuni.jsonprocessing.productsShop.utils.FormatConverter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;

@Controller
public class ConsoleRunner implements CommandLineRunner {

    private static final String BASE_INPUT_PATH_JSON = "./src/main/resources/jsonImport/";
    private static final String BASE_OUTPUT_PATH_JSON = "./src/main/resources/jsonExports/";
    private static final String BASE_INPUT_PATH_XML = "./src/main/resources/xmlImports/";
    private static final String BASE_OUTPUT_PATH_XML = "./src/main/resources/xmlExports/";
    private static final String PRODUCTS_NO_BUYER_PATH = "products-no-buyer.xml";
    private static final String USERS_WITH_SOLD_PRODUCTS = "users-with-sold-products.xml";
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final Gson gson;
    private final FormatConverter formatConverter;
    private boolean categoriesNotAssigned = true;

    public ConsoleRunner(UserService userService, ProductService productService, CategoryService categoryService, Gson gson, FormatConverter formatConverter) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.gson = gson;
        this.formatConverter = formatConverter;
    }

    @Override
    public void run(String... args) throws Exception {
        seedDataFromXML();
        assignCategoriesToProducts();
        queryOne_ProductsInRange();
        queryTwo_SuccessfullySoldProducts();
    }

    private void queryTwo_SuccessfullySoldProducts() {
        UsersWithSoldProducts allUsersWhoHaveSoldAnItem = userService.getAllUsersWhoHaveSoldAnItem();
        formatConverter.serializeToFile(allUsersWhoHaveSoldAnItem, BASE_OUTPUT_PATH_XML + USERS_WITH_SOLD_PRODUCTS);
    }

    private void queryOne_ProductsInRange() {
        ProductsNoBuyer products = productService
                .exportProductsInAPriceRangeWithNoBuyer(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));
        formatConverter.serializeToFile(products, BASE_OUTPUT_PATH_XML + PRODUCTS_NO_BUYER_PATH);
    }

    private void seedDataFromXML() {
        try {
            seedUsersDataFromXML();
            seedCategoriesDataFromXML();
            seedProductsDataFromXML();
        } catch (FileCouldNotBeSerialized e) {
            e.printStackTrace();
        }
    }

    private void seedProductsDataFromXML() throws FileCouldNotBeSerialized {
        if (productService.productTableIsEmpty()) {
            ProductsSeed productsSeed = formatConverter
                    .deserializeFromFile(BASE_INPUT_PATH_XML + "products.xml", ProductsSeed.class);
            productService.seedProducts(productsSeed);
        }
    }

    private void seedCategoriesDataFromXML() throws FileCouldNotBeSerialized {
        if (categoryService.categoryTableIsEmpty()) {
            CategoriesSeed categoriesSeed = formatConverter
                    .deserializeFromFile(BASE_INPUT_PATH_XML + "categories.xml", CategoriesSeed.class);
            categoryService.seedCategories(categoriesSeed);
        }
    }

    private void seedUsersDataFromXML() throws FileCouldNotBeSerialized {
        if (userService.userTableIsEmpty()) {
            UsersSeed usersSeed = formatConverter
                    .deserializeFromFile(BASE_INPUT_PATH_XML + "users.xml", UsersSeed.class);
            userService.seedUsers(usersSeed);
        }
    }

    private void assignCategoriesToProducts() {
        if (categoriesNotAssigned) {
            productService.assignCategories();
            categoriesNotAssigned = false;
        }
    }

    private void seedDataFromJson() throws FileNotFoundException {
        seedUserDataFromJson();
        seedCategoryDataFromJson();
        seedProductDataFromJson();
    }

    private void seedCategoryDataFromJson() throws FileNotFoundException {
        if (categoryService.categoryTableIsEmpty()) {
            CategorySeed[] categorySeeds = gson.fromJson(new FileReader(BASE_INPUT_PATH_JSON + "categories.json"), CategorySeed[].class);

            categoryService.seedCategories(categorySeeds);
        }
    }

    private void seedProductDataFromJson() throws FileNotFoundException {
        if (productService.productTableIsEmpty()) {
            ProductSeed[] productSeeds = gson.fromJson(new FileReader(BASE_INPUT_PATH_JSON + "products.json"), ProductSeed[].class);
            productService.seedProducts(productSeeds);
        }
    }

    private void seedUserDataFromJson() throws FileNotFoundException {
        if (userService.userTableIsEmpty()) {
            UserSeed[] userSeeds = gson.fromJson(new FileReader(BASE_INPUT_PATH_JSON + "users.json"), UserSeed[].class);
            userService.seedUsers(userSeeds);
        }
    }
}
