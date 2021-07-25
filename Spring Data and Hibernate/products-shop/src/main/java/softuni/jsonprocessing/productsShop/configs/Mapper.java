package softuni.jsonprocessing.productsShop.configs;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.jsonprocessing.productsShop.models.dtos.ProductNoBuyer;
import softuni.jsonprocessing.productsShop.models.entities.Product;

@Configuration
public class Mapper {

    @Bean
    @Qualifier(value = "General")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
