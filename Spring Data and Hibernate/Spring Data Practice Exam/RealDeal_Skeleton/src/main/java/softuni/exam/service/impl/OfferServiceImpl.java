package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferDataSeed;
import softuni.exam.models.dto.OffersDataSeed;
import softuni.exam.models.dto.SellerSeedData;
import softuni.exam.models.dto.SellersSeedData;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String XML_INPUT_OFFERS = "./src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    public OfferServiceImpl(OfferRepository offerRepository, ValidationUtil validator, ModelMapper mapper) {
        this.offerRepository = offerRepository;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(XML_INPUT_OFFERS));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(OffersDataSeed.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        OffersDataSeed offersSeedData = (OffersDataSeed) unmarshaller.unmarshal(new FileReader(XML_INPUT_OFFERS));

        StringBuilder output = new StringBuilder();
        for (OfferDataSeed offerData : offersSeedData.getOffers()) {
            Set<ConstraintViolation<OfferDataSeed>> violations = validator.getViolations(offerData);
            if (!violations.isEmpty()) {
                output.append("Invalid offer").append(System.lineSeparator());
                continue;
            }
            Offer offer = mapper.map(offerData, Offer.class);
            offer.setPictures(offer.getCar().getPictures());
            offerRepository.save(offer);
            output.append(String.format("Successfully imported offer %s - %b%n", offer.getAddedOn(), offer.isHasGoldStatus()));
        }
        return output.toString();
    }
}
