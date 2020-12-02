package softuni.fundamentals.java;

import java.util.Random;
import java.util.Scanner;

public class Lab01Advertisement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int messages = scan.nextInt();
        String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};
        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        for (int i = 0; i < messages; i++) {
            printRandomMessage(phrases, events, authors, cities);
        }
    }

    static void printRandomMessage(String[] phrases, String[] events, String[] authors, String[] cities) {
        Random randomizer = new Random();
        int phrase = randomizer.nextInt(phrases.length);
        int event = randomizer.nextInt(events.length);
        int author = randomizer.nextInt(authors.length);
        int city = randomizer.nextInt(cities.length);
        System.out.printf("%s %s %s - %s%n", phrases[phrase], events[event], authors[author], cities[city]);
    }
}
