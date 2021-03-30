import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductStockTest {
    private static final int PRODUCTS_SIZE = 8;

    private Instock inStock;
    private Product product;

    @Before
    public void setUp() {
        inStock = new Instock();
        product = new Product("Heinz BBQ Sauce", 5.99, 125);
    }

    @Test
    public void testGetCountShouldReturnTwoWhenTwoProductsAreAdded() {
        addProducts();
        assertEquals(Integer.valueOf(PRODUCTS_SIZE), inStock.getCount());
    }

    @Test
    public void testGetCountShouldReturnZeroWhenEmpty() {
        assertEquals(Integer.valueOf(0), inStock.getCount());
    }

    @Test
    public void testAddProductStoresTheProductInTheCollectionByValidatingWithContains() {
        inStock.add(product);
        Boolean contains = inStock.contains(product);
        assertNotNull(contains);
        assertTrue(contains);
    }

    @Test
    public void testContainsReturnsFalseWhenProductIsNotPresent() {
        inStock.add(product);
        Boolean contains = inStock.contains(new Product("Leiseur Light Mayonaisse", 6.99, 85));
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test
    public void testAddDoesNotAddTheSameProductTwice() {
        inStock.add(product);
        inStock.add(product);
        Integer count = inStock.getCount();
        assertNotNull(count);
        assertEquals(Integer.valueOf(1), count);
    }

    @Test
    public void testContainsReturnsFalseWhenEmpty() {
        Boolean contains = inStock.contains(product);
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test
    public void testFindReturnsThe1stElementInTheCollection() {
        assertFindReturnsCorrectProduct(0);
    }

    @Test
    public void testFindReturnsThe4thElementInTheCollection() {
        assertFindReturnsCorrectProduct(3);
    }

    @Test
    public void testFindReturnsTheLastElementInTheCollection() {
        assertFindReturnsCorrectProduct(7);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldFailWhenIndexOutOfBoundsWhenIndexIsEqualToCount() {
        addProducts();
        inStock.find(inStock.getCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldFailWhenIndexOutOfBoundsWhenNegativeIndex() {
        addProducts();
        inStock.find(-1);
    }

    @Test
    public void testChangeQuantityChangesQuantityValueByGivenAmount() {
        inStock.add(product);
        int previousQuantity = product.getQuantity();
        inStock.changeQuantity(product.getLabel(), 20);
        assertEquals(previousQuantity + 20, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityFailsWhenThereIsNoSuchProduct() {
        addProducts();
        inStock.changeQuantity(product.getLabel(), 20);
    }

    private void assertFindReturnsCorrectProduct(int index) {
        addProducts();
        assertEquals(Integer.valueOf(PRODUCTS_SIZE), inStock.getCount());
        Product product = inStock.find(index);
        assertNotNull(product);
        assertEquals("test_label_" + index, product.getLabel());
    }

    private void addProducts() {
        inStock.add(new Product("test_label_0", 5.99, 125));
        inStock.add(new Product("test_label_1", 6.99, 85));
        inStock.add(new Product("test_label_2", 100,  12));
        inStock.add(new Product("test_label_3", 1.15, 760));
        inStock.add(new Product("test_label_4", 48.69, 1866));
        inStock.add(new Product("test_label_5", 3655, 33));
        inStock.add(new Product("test_label_6", 0.62, 11350));
        inStock.add(new Product("test_label_7", 77, 42));
    }
}