import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void testFindByLabelReturnsTheCorrectProduct() {
        addProducts();
        inStock.add(product);
        Product byLabel = inStock.findByLabel(product.getLabel());
        assertNotNull(byLabel);
        assertEquals(product, byLabel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelFailsWhenProductIsMissing() {
        addProducts();
        inStock.findByLabel(product.getLabel());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsTheCorrectItems() {
        addProducts();
        List<Product> returned = getProducts(inStock.findFirstByAlphabeticalOrder(3));
        List<Product> list = addProductsToLocalList();
        List<Product> expected = list.stream().sorted().limit(3).collect(Collectors.toList());
        compareListsByLabel(expected, returned);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsEmptyCollectionIfCountIsOutOfRange() {
        List<Product> products = getProducts(inStock.findFirstByAlphabeticalOrder(PRODUCTS_SIZE + 1));
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllInRangeReturnsTheCorrectProducts() {
        double lowPrice = 1.15;
        double highPrice = 50;
        addProducts();
        List<Product> returned = getProducts(inStock.findAllInRange(lowPrice, highPrice));
        List<Product> expected = addProductsToLocalList();
        expected = expected.stream().filter(e -> e.getPrice() > lowPrice && e.getPrice() <= highPrice)
                .sorted((e1, e2) -> Double.compare(e2.getPrice(), e1.getPrice()))
                .collect(Collectors.toList());
        compareListsByLabel(expected, returned);
    }

    @Test
    public void testFindAllInRangeReturnsEmptyCollectionWhenNoProductsInRange() {
        addProducts();
        List<Product> productList = getProducts(inStock.findAllInRange(4500, 6000));
        assertTrue(productList.isEmpty());
    }

    @Test
    public void testFindAllByPriceReturnsAllProductsWithGivenPrice() {
        double price = product.price;
        addProducts();
        inStock.add(product);
        List<Product> returned = getProducts(inStock.findAllByPrice(price));
        List<Product> expected = addProductsToLocalList();
        expected.add(product);
        expected = expected.stream()
                .filter(e -> e.getPrice() == price)
                .collect(Collectors.toList());
        compareListsByLabel(expected, returned);
    }

    @Test
    public void testFindAllByPriceReturnsEmptyCollectionWhenNoProductsMatchPrice() {
        addProducts();
        List<Product> products = getProducts(inStock.findAllByPrice(9));
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsReturnsTheRightProducts() {
        int productsCounts = 4;
        addProducts();
        List<Product> returned = getProducts(inStock.findFirstMostExpensiveProducts(productsCounts));
        List<Product> expected = addProductsToLocalList().stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(4)
                .collect(Collectors.toList());
        compareListsByLabel(expected, returned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsFailsWhenCountIsOutOfBounds() {
        addProducts();
        getProducts(inStock.findFirstMostExpensiveProducts(inStock.getCount() + 1));
    }

    private List<Product> getProducts(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> returned = new ArrayList<>();
        iterable.forEach(returned::add);
        return returned;
    }

    private void compareListsByLabel(List<Product> expected, List<Product> returned) {
        assertEquals(expected.size(), returned.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getLabel(), returned.get(i).getLabel());
        }
    }

    private void assertFindReturnsCorrectProduct(int index) {
        addProducts();
        assertEquals(Integer.valueOf(PRODUCTS_SIZE), inStock.getCount());
        Product product = inStock.find(index);
        assertNotNull(product);
        assertEquals("test_label_" + index, product.getLabel());
    }

    private void addProducts() {
        List<Product> products = addProductsToLocalList();
        for (Product product1 : products) {
            inStock.add(product1);
        }
    }

    private List<Product> addProductsToLocalList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("test_label_0", 5.99, 125));
        products.add(new Product("test_label_1", 6.99, 85));
        products.add(new Product("test_label_2", 100, 12));
        products.add(new Product("test_label_3", 1.15, 760));
        products.add(new Product("test_label_4", 48.69, 1866));
        products.add(new Product("test_label_5", 3655, 33));
        products.add(new Product("test_label_6", 0.62, 11350));
        products.add(new Product("test_label_7", 77, 42));
        return products;
    }
}