package softuni.fundamentals.java;

import java.util.*;

public class Lab04Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        Map<String, Product> products = new LinkedHashMap<>();
        while (!input[0].equals("buy")) {
            String name = input[0];
            double price = Double.parseDouble(input[1]);
            int quantity = Integer.parseInt(input[2]);
            if (!products.containsKey(name)) {
                products.put(name, new Product(price, quantity));
            }
            else {
                products.get(name).setPrice(price);
                products.get(name).setQuantity(quantity);
            }
            input = scan.nextLine().split(" ");
        }

        for (Map.Entry<String, Product> entry : products.entrySet()) {
            System.out.printf("%s -> %.2f%n",entry.getKey(), entry.getValue().getTotalPrice());
        }

    }
}

class Product {
    int quantity;
    double price;

    Product (double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    public double getTotalPrice() {
        return price*quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
