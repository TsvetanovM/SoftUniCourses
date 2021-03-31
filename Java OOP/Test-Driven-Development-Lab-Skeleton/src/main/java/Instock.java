import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private Map<String, Product> products;

    public Instock() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public Integer getCount() {
        return products.size();
    }

    @Override
    public Boolean contains(Product product) {
        return this.products.containsKey(product.getLabel());
    }

    @Override
    public void add(Product product) {
        if (!contains(product)) {
            this.products.put(product.getLabel(), product);
        }
    }

    @Override
    public void changeQuantity(String label, int quantity) {
        checkIfProductExists(label);
        Product product = this.products.get(label);
        product.setQuantity(product.getQuantity() + quantity);
    }

    @Override
    public Product find(int index) {
        return new ArrayList<>(this.products.values()).get(index);
    }

    @Override
    public Product findByLabel(String label) {
        checkIfProductExists(label);
        return products.get(label);
    }

    private void checkIfProductExists(String label) {
        if (!this.products.containsKey(label)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count > this.getCount() || count <= 0) {
            return new ArrayList<>();
        }
       return products.values().stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> products = this.products.values().stream()
                .filter(e -> e.getPrice() > lo && e.getPrice() <= hi)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());

        Collections.reverse(products);
        return products;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> priceMatched = new ArrayList<>();
        for (Product value : products.values()) {
            if (value.getPrice() == price) {
                priceMatched.add(value);
            }
        }
        return priceMatched;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count < 0 || count > this.products.size()) {
            throw new IllegalArgumentException();
        }
        List<Product> productList = new ArrayList<>(this.products.values());
        productList.sort(Comparator.comparingDouble(Product::getPrice));
        Collections.reverse(productList);
        return productList.stream().limit(4).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.products.values()
                .stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());

    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.values().iterator();
    }
}
