package bg.marto.softuni_mobilelele.init;

import bg.marto.softuni_mobilelele.model.entity.Brand;
import bg.marto.softuni_mobilelele.model.entity.Model;
import bg.marto.softuni_mobilelele.model.enums.Category;
import bg.marto.softuni_mobilelele.repository.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;

    public DBInit(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (brandRepository.count() == 0) {
            Brand ford = new Brand().setName("Ford");

            Model fiesta = new Model().setName("Fiesta")
                    .setCategory(Category.CAR).setStartYear(1976)
                    .setImageUrl("https://www.google.com/search?q=ford+fiesta&sxsrf=AOaemvI5tcBaWwN8aHNBcK1lOgZYm3uqKg:1633604801014&tbm=isch&source=iu&ictx=1&fir=_X0f359b0IuscM%252C27EDpNe5AZUPOM%252C_%253BLMsCDyDhykHFZM%252C6Sy90h4HcaE6WM%252C_%253BV9w25LyN4iM-lM%252CoARYU3Ctq_AiCM%252C_%253BgOuprlzMGaJtKM%252CB7r_syYL8ywsLM%252C_%253B5b5Ua_El8oWzdM%252CwLvKQVuPJIR08M%252C_%253Bq3DGK3BWYAV8CM%252C6Sy90h4HcaE6WM%252C_%253BrTAFBT75btn5FM%252CHUBKEQQuZiw0UM%252C_%253BuqJ9AzZXOUfJsM%252CFFw-AxOkuU-BtM%252C_%253BuGINYl6hPzjVmM%252CFFw-AxOkuU-BtM%252C_%253BnbhvRG9PDxOToM%252CwLvKQVuPJIR08M%252C_&vet=1&usg=AI4_-kRXSnNWQP9p0vvYZBkWJfVeaNNT6w&sa=X&sqi=2&ved=2ahUKEwj58PeOlLjzAhU8lWoFHSWECPwQ9QF6BAgREAE#imgrc=_X0f359b0IuscM");

            Model mondeo = new Model().setName("Mondeo")
                    .setCategory(Category.CAR)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Ford_Mondeo_Silver_VL.jpg/275px-Ford_Mondeo_Silver_VL.jpg")
                    .setStartYear(1993);

            fiesta.setBrand(ford);
            mondeo.setBrand(ford);
            ford.setModel(List.of(fiesta, mondeo));

            brandRepository.save(ford);
        }
    }
}
