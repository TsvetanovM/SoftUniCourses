package softuni.jsonprocessing.productsShop.utils;

import org.springframework.stereotype.Component;
import softuni.jsonprocessing.productsShop.exceptions.FileCouldNotBeSerialized;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class FormatConverterImpl implements FormatConverter {

    @Override
    public String serialize(Object obj) {
        return null;
    }

    @Override
    public void serialize(Object o, String fileName) {

    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public <T> T deserializeFromFile(String fileName, Class<T> toClass) throws FileCouldNotBeSerialized {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(toClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new FileReader(fileName));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new FileCouldNotBeSerialized();
    }
}
