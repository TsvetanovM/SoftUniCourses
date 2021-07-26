package softuni.jsonprocessing.productsShop.utils;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
    public <T> T deserializeFromFile(String fileName, Class<T> toClass) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(toClass);
            InputStream inputStream = getClass().getResourceAsStream(fileName);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
           return (T) unmarshaller.unmarshal(bfr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
