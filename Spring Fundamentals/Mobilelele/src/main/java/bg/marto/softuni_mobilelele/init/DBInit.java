package bg.marto.softuni_mobilelele.init;

import bg.marto.softuni_mobilelele.model.entity.Brand;
import bg.marto.softuni_mobilelele.model.entity.Model;
import bg.marto.softuni_mobilelele.model.enums.Category;
import bg.marto.softuni_mobilelele.repository.BrandRepository;
import bg.marto.softuni_mobilelele.repository.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    public DBInit(BrandRepository brandRepository, ModelRepository modelRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (brandRepository.count() == 0) {
            Brand ford = new Brand().setName("Ford");

            Model fiesta = new Model().setName("Fiesta")
                    .setCategory(Category.CAR).setStartYear(1976)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/275px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");

            Model mondeo = new Model().setName("Mondeo")
                    .setCategory(Category.CAR)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Ford_Mondeo_Silver_VL.jpg/275px-Ford_Mondeo_Silver_VL.jpg")
                    .setStartYear(1993);

            fiesta.setBrand(ford);
            mondeo.setBrand(ford);
            ford.setModel(List.of(fiesta, mondeo));

            brandRepository.save(ford);
//            modelRepository.save(fiesta);
//            modelRepository.save(mondeo);
        }
    }
}
