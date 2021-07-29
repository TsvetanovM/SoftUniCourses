package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarSeedData;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;

import java.io.FileReader;
import java.io.IOException;

@Service
public class CarServiceImpl implements CarService {

    private static final String JSON_INPUT_CARS = "./src/main/resources/files/json/cars.json";

    private final CarRepository carRepository;
    private final Gson gson;

    public CarServiceImpl(CarRepository carRepository, Gson gson) {
        this.carRepository = carRepository;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        CarSeedData[] carSeedData = gson.fromJson(new FileReader(JSON_INPUT_CARS), CarSeedData[].class);
        for (CarSeedData seedData : carSeedData) {

        }
        return null;
    }

    @Override
    public String importCars() throws IOException {
        return null;
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        return null;
    }
}
