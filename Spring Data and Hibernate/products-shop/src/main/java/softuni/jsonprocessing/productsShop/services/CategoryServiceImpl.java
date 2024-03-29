package softuni.jsonprocessing.productsShop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.jsonprocessing.productsShop.models.dtos.CategoriesSeed;
import softuni.jsonprocessing.productsShop.models.dtos.CategorySeed;
import softuni.jsonprocessing.productsShop.models.entities.Category;
import softuni.jsonprocessing.productsShop.repositories.CategoryRepository;
import softuni.jsonprocessing.productsShop.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, @Qualifier("General") ModelMapper mapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
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
            validateCategoryAndPersist(categorySeed);
        }
    }

    @Override
    public void seedCategories(CategoriesSeed categoriesSeed) {
        for (CategorySeed categorySeed : categoriesSeed.getCategories()) {
            validateCategoryAndPersist(categorySeed);
        }
    }

    private void validateCategoryAndPersist(CategorySeed categorySeed) {
        Set<ConstraintViolation<CategorySeed>> violations = validationUtil.getViolations(categorySeed);
        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }
        Category category = mapper.map(categorySeed, Category.class);

        categoryRepository.save(category);
    }
}
