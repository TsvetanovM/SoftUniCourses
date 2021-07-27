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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Controller
public class ConsoleRunner implements CommandLineRunner {

    private static final String BASE_INPUT_PATH_JSON = "./src/main/resources/jsonImport/";
    private static final String BASE_OUTPUT_PATH_JSON = "./src/main/resources/jsonExports/";
    private static final String BASE_INPUT_PATH_XML = "./src/main/resources/xmlImports/";
    private static final String PRODUCTS_NO_BUYER_PATH = "products-no-buyer.json";
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final Gson gson;
    private final FormatConverter formatConverter;

    public ConsoleRunner(UserService userService, ProductService productService, CategoryService categoryService, Gson gson, FormatConverter formatConverter) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.gson = gson;
        this.formatConverter = formatConverter;
    }

    @Override
    public void run(String... args) throws Exception {
//        try {
            seedDataFromXML();
//            query1();
//            assignCategoriesToProducts();
//        } catch (FileNotFoundException e) {
//            System.out.println("No such file found in the provided path!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void seedDataFromXML() {
        try {
            seedUsersDataFromXML();
        } catch (FileCouldNotBeSerialized e) {
            e.printStackTrace();
        }
    }

    private void seedUsersDataFromXML() throws FileCouldNotBeSerialized {
        if (userService.userTableIsEmpty()) {
            UsersSeed usersSeed = formatConverter
                    .deserializeFromFile(BASE_INPUT_PATH_XML + "users.xml", UsersSeed.class);
            userService.seedUsers(usersSeed);
        }
    }

    private void query1() throws IOException {
        List<ProductNoBuyer> products = productService
                .exportProductsInAPriceRangeWithNoBuyer(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));
        String toJson = gson.toJson(products);
        writeToJsonFile(BASE_OUTPUT_PATH_JSON + PRODUCTS_NO_BUYER_PATH, toJson);
    }



    private void writeToJsonFile(String path, String toJson) throws IOException {
        Files.write(Path.of(path), Collections.singleton(toJson));
    }

    private void assignCategoriesToProducts() {
        productService.assignCategories();
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
