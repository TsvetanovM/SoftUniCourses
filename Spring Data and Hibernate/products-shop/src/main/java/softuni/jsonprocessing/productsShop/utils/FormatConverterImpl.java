package softuni.jsonprocessing.productsShop.utils;

import org.springframework.stereotype.Component;
import softuni.jsonprocessing.productsShop.exceptions.FileCouldNotBeSerialized;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class FormatConverterImpl implements FormatConverter {

    @Override
    public <T> void serializeToFile(T entity, String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(entity.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(entity, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
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
