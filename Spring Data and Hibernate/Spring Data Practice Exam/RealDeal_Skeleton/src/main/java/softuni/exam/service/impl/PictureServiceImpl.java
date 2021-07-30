package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarSeedData;
import softuni.exam.models.dto.PictureSeedData;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String JSON_INPUT_PICTURES = "./src/main/resources/files/json/pictures.json";

    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ModelMapper mapper, ValidationUtil validator) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(JSON_INPUT_PICTURES));
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder output = new StringBuilder();

        PictureSeedData[] pictureSeedData = gson.fromJson(readPicturesFromFile(), PictureSeedData[].class);
        for (PictureSeedData seedData : pictureSeedData) {
            Set<ConstraintViolation<PictureSeedData>> violations = validator.getViolations(seedData);
            if (!violations.isEmpty()) {
                output.append("Invalid picture").append(System.lineSeparator());
                continue;
            }
            Picture picture = mapper.map(seedData, Picture.class);
            pictureRepository.save(picture);
            output.append(String.format("Successfully imported picture - %s%n", picture.getName()));
        }
        return output.toString();
    }
}
