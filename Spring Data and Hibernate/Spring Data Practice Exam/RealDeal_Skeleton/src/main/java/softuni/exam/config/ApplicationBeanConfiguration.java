package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.SellerRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Configuration
public class ApplicationBeanConfiguration {

    private final CarRepository carRepository;
    private final SellerRepository sellerRepository;

    public ApplicationBeanConfiguration(CarRepository carRepository, SellerRepository sellerRepository) {
        this.carRepository = carRepository;
        this.sellerRepository = sellerRepository;
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelmapper = new ModelMapper();

        modelmapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });

        modelmapper.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(MappingContext<String, LocalDateTime> mappingContext) {
                return LocalDateTime.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        });

        modelmapper.addConverter(new Converter<Long, Car>() {
            @Override
            public Car convert(MappingContext<Long, Car> mappingContext) {
                return carRepository.findById(mappingContext.getSource()).orElse(null);
            }
        });

        modelmapper.addConverter(new Converter<Long, Seller>() {
            @Override
            public Seller convert(MappingContext<Long, Seller> mappingContext) {
                return sellerRepository.findById(mappingContext.getSource()).orElse(null);
            }
        });

        return modelmapper;
    }

}
