package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String XML_INPUT_OFFERS = "./src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
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
