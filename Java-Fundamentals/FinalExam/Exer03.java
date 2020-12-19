import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exer03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Hero> allHeroes = new TreeMap<>();

        while (!input.equals("Results")) {
            String[] instructions = input.split(":");
            String command = instructions[0];
            switch (command) {
                case "Add":
                    String heroName = instructions[1];
                    int health = Integer.parseInt(instructions[2]);
                    int energy = Integer.parseInt(instructions[3]);
                    allHeroes.putIfAbsent(heroName, new Hero(heroName, 0, energy));
                    allHeroes.get(heroName).setHealth(health);
                    break;
                case "Attack":
                    String attackerName = instructions[1];
                    String defenderName = instructions[2];
                    int damage = Integer.parseInt(instructions[3]);
                    if (!allHeroes.containsKey(attackerName) || !allHeroes.containsKey(defenderName)) {
                        input = scan.nextLine();
                        continue;
                    }
                    allHeroes.get(defenderName).setHealth(damage*-1);
                    if (allHeroes.get(defenderName).getHealth()<=0){
                        System.out.println(defenderName + " was disqualified!");
                        allHeroes.remove(defenderName);
                    }
                    allHeroes.get(attackerName).setEnergy(1);
                    if (allHeroes.get(attackerName).getEnergy()==0) {
                        System.out.println(attackerName + " was disqualified!");
                        allHeroes.remove(attackerName);
                    }
                    break;
                case "Delete":
                    String username = instructions[1];
                    if (username.equals("All")){
                        allHeroes.clear();
                        input = scan.nextLine();
                        continue;
                    }
                    if (!allHeroes.containsKey(username)){
                        input = scan.nextLine();
                        continue;
                    }
                    allHeroes.remove(username);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("People count: " + allHeroes.size());
        allHeroes.entrySet().stream()
                .sorted((h1,h2) -> Integer.compare(h2.getValue().getHealth(),h1.getValue().getHealth()))
                .forEach(h -> System.out.printf("%s - %d - %d%n", h.getKey(), h.getValue().getHealth(), h.getValue().getEnergy()));
    }
}

class Hero {
    String name;
    int health;
    int energy;

    Hero(String name, int health, int energy) {
        this.name = name;
        this.health = health;
        this.energy = energy;
    }

    public int getHealth() {
        return health;
    }

    public int getEnergy() {
        return energy;
    }

    public void setHealth(int health) {
        this.health += health;
    }

    public void setEnergy(int energy) {
        this.energy -= energy;
    }
}