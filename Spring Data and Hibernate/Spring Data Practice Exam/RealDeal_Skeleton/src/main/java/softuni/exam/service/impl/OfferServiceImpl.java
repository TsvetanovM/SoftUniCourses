package softuni.exam.service.impl;

import softuni.exam.service.OfferService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class OfferServiceImpl implements OfferService {
    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return null;
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        return null;
    }
}
