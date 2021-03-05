package EncapsulationExercises;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= money) {
            money -= product.getCost();
            products.add(product);
            System.out.println(getName() + " bought " + product.getName());
        } else {
            System.out.println(getName() + " can't afford " + product.getName());
        }
    }

    @Override
    public String toString() {
        if (!products.isEmpty()) {
            StringBuilder output = new StringBuilder(getName() + " - ");
            for (Product product : products) {
                output.append(product.getName()).append(", ");
            }
            return output.deleteCharAt(output.length() - 2).toString().trim();
        }
        return getName() + " - Nothing bought";
    }
}
