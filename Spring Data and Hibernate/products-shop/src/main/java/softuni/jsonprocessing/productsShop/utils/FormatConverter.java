package softuni.jsonprocessing.productsShop.utils;

import softuni.jsonprocessing.productsShop.exceptions.FileCouldNotBeSerialized;

import javax.xml.bind.JAXBException;
import java.io.FileReader;

public interface FormatConverter {

    <T> void serializeToFile(T entity, String fileName);

    <T> T deserializeFromFile(String fileName, Class<T> toClass) throws FileCouldNotBeSerialized;
}
