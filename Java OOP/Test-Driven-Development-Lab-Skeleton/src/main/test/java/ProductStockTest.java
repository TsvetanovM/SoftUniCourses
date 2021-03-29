import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductStockTest {

    private ProductStock inStock;

    @Before
    public void setUp() {
        inStock = new Instock();
    }

    @Test
    public void testGetCountShouldReturnTwoWhenTwoProductsAreAdded() {
        inStock.add(new Product("Heinz BBQ Sauce", 5.99, 125));
        inStock.add(new Product("Leiseur Light Mayonaisse", 6.99, 85));

        assertEquals(Integer.valueOf(2), inStock.getCount());
    }

    @Test
    public void testGetCountShouldReturnZeroWhenEmpty() {
        assertEquals(Integer.valueOf(0) , inStock.getCount());
    }
}