package softuni.jsonprocessing.productsShop.services;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.jsonprocessing.productsShop.models.dtos.CategorySeed;
import softuni.jsonprocessing.productsShop.models.entities.Category;
import softuni.jsonprocessing.productsShop.repositories.CategoryRepository;
import softuni.jsonprocessing.productsShop.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ModelMapper mapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean categoryTableIsEmpty() {
        return categoryRepository.count() == 0;
    }

    @Override
    public void seedCategories(CategorySeed[] categorySeeds) {
        for (CategorySeed categorySeed : categorySeeds) {
            Set<ConstraintViolation<CategorySeed>> violations = validationUtil.getViolations(categorySeed);
            if (!violations.isEmpty()) {
                violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
                continue;
            }
            Category category = mapper.map(categorySeed, Category.class);

            categoryRepository.save(category);
        }
    }
}
