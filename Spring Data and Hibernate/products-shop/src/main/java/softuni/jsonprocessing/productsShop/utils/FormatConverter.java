package softuni.jsonprocessing.productsShop.utils;

import java.io.FileReader;

public interface FormatConverter {

    String serialize(Object obj);

    void serialize(Object o, String fileName);

    <T> T deserializeFromFile(String fileName, Class<T> toClass);
}
