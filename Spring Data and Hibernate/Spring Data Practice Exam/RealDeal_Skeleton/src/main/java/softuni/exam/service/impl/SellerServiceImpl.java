package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerSeedData;
import softuni.exam.models.dto.SellersSeedData;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class SellerServiceImpl implements SellerService {

    private static final String XML_INPUT_SELLERS = "./src/main/resources/files/xml/sellers.xml";

    private final SellerRepository sellerRepository;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    public SellerServiceImpl(SellerRepository sellerRepository, ValidationUtil validator, ModelMapper mapper) {
        this.sellerRepository = sellerRepository;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(XML_INPUT_SELLERS));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(SellersSeedData.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SellersSeedData sellersSeedData = (SellersSeedData) unmarshaller.unmarshal(new FileReader(XML_INPUT_SELLERS));

        StringBuilder output = new StringBuilder();
        for (SellerSeedData sellerData : sellersSeedData.getSellers()) {
            Set<ConstraintViolation<SellerSeedData>> violations = validator.getViolations(sellerData);
            if (!violations.isEmpty()) {
                output.append("Invalid seller").append(System.lineSeparator());
                continue;
            }
            Seller seller = mapper.map(sellerData, Seller.class);
            sellerRepository.save(seller);
            output.append(String.format("Successfully imported seller %s - %s%n", seller.getLastName(), seller.getEmail()));
        }
        return output.toString();
    }
}
