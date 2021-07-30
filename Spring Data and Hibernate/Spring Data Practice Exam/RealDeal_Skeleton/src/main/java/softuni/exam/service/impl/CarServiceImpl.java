package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarSeedData;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    private static final String JSON_INPUT_CARS = "./src/main/resources/files/json/cars.json";

    private final CarRepository carRepository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    public CarServiceImpl(CarRepository carRepository, Gson gson, ValidationUtil validator, ModelMapper mapper) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(JSON_INPUT_CARS));
    }

    @Override
    public String importCars() throws IOException {
                StringBuilder output = new StringBuilder();

        CarSeedData[] carSeedData = gson.fromJson(readCarsFileContent(), CarSeedData[].class);
                for (CarSeedData seedData : carSeedData) {
            Set<ConstraintViolation<CarSeedData>> violations = validator.getViolations(seedData);
            if (!violations.isEmpty()) {
                output.append("Invalid car").append(System.lineSeparator());
                continue;
            }
            Car car = mapper.map(seedData, Car.class);
            carRepository.save(car);
            output.append(String.format("Successfully imported car - %s - %s%n", car.getMake(), car.getModel()));
        }
        return output.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        return null;
    }
}
