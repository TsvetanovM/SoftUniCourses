package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab05NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] demonNames = scan.nextLine().split(",\\s*");
        List<Demon> demons = new ArrayList<>();

        for (String name : demonNames) {
            double damage = 0;
            Pattern pattern1 = Pattern.compile("[+-]?\\d+\\.?\\d*");
            Matcher matcher1 = pattern1.matcher(name);
            while (matcher1.find()) {
                double attack = Double.parseDouble(matcher1.group());
                damage += attack;
            }
            if (damage!=0) {
                for (int j = 0; j < name.length(); j++) {
                    char current = name.charAt(j);
                    if (current == '/') {
                        damage /= 2;
                    }
                    if (current == '*') {
                        damage *= 2;
                    }
                }
            }

            Pattern pattern2 = Pattern.compile("[^-0-9+*/.]");
            Matcher matcher2 = pattern2.matcher(name);
            int health = 0;
            while (matcher2.find()){
                health += matcher2.group().charAt(0);
            }
                demons.add(new Demon(name, health, damage));
        }

        demons.sort(Comparator.comparing(Demon::getName));
        demons.forEach(d -> System.out.printf("%s - %d health, %.2f damage%n", d.getName(), d.getHealth(), d.getDamage()));
    }
}

class Demon {
    String name;
    int health;
    double damage;

    Demon(String name, int health, double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }
}
