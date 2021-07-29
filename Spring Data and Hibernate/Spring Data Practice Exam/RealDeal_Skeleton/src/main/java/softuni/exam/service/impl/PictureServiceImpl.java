package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String JSON_INPUT_PICTURES = "./src/main/resources/files/json/pictures.json";

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return null;
    }

    @Override
    public String importPictures() throws IOException {
        return null;
    }
}
