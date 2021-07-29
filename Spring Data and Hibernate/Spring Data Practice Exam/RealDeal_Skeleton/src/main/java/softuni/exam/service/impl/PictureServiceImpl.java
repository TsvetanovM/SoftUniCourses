package softuni.exam.service.impl;

import softuni.exam.service.PictureService;

import java.io.IOException;

public class PictureServiceImpl implements PictureService {
    @Override
    public boolean areImported() {
        return false;
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
