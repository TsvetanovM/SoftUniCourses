package softuni.jsonprocessing.productsShop.configs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class gson {

    @Bean
    public Gson gsonFactory() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting().create();
    }
}
