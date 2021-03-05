package EncapsulationExercises;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> allPeople = new LinkedHashMap<>();

        String[] people = getStringArray(scanner.nextLine(), ";");
        for (String person : people) {
            createPerson(allPeople, person);
        }

        Map<String, Product> allProducts = new LinkedHashMap<>();
        String[] products = getStringArray(scanner.nextLine(), ";");
        for (String product : products) {
            createProduct(allProducts, product);
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = getStringArray(command, "\\s+");
            String personName = tokens[0];
            String productName = tokens[1];
            allPeople.get(personName).buyProduct(allProducts.get(productName));
            command = scanner.nextLine();
        }

        for (Person person : allPeople.values()) {
            System.out.println(person.toString());
        }
    }

    private static void createPerson(Map<String, Person> map, String person) {
        String[] personDetails = getStringArray(person, "=");
        String name = personDetails[0];
        map.put(name, new Person(name, Double.parseDouble(personDetails[1])));
    }

    private static String[] getStringArray(String s, String pattern) {
        return s.split(pattern);
    }

    private static void createProduct(Map<String, Product> map, String person) {
        String[] personDetails = getStringArray(person, "=");
        String name = personDetails[0];
        map.put(name, new Product(name, Double.parseDouble(personDetails[1])));
    }
}
