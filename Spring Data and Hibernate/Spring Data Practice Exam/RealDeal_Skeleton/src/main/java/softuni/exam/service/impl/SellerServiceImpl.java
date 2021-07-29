package softuni.exam.service.impl;

import softuni.exam.service.SellerService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class SellerServiceImpl implements SellerService {
    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return null;
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        return null;
    }
}
