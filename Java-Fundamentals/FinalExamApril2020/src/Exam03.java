import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Exam03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<City> cities = new ArrayList<>();

        while (!input.equals("Sail")) {
            String[] cityInfo = input.split("\\|\\|");
            input = scan.nextLine();
            String cityName = cityInfo[0];
            int population = Integer.parseInt(cityInfo[1].trim());
            int gold = Integer.parseInt(cityInfo[2].trim());
            boolean alreadyExists = false;
            for (City city : cities) {
                if (city.getName().equals(cityName)) {
                    city.setPopulation(city.getPopulation() + population);
                    city.setGold(city.getGold() + gold);
                    alreadyExists = true;
                    break;
                }
            }
            if (!alreadyExists) {
                cities.add(new City(cityName, population, gold));
            }
        }

        String event = scan.nextLine();
        while (!event.equals("End")) {
            String[] tokens = event.split("=>");
            String action = tokens[0];
            String town = tokens[1];
            switch (action) {
                case "Plunder":
                    int population = Integer.parseInt(tokens[2].trim());
                    int gold = Integer.parseInt(tokens[3].trim());
                    for (City city : cities) {
                        if (town.equals(city.getName())) {
                            city.plunder(population, gold);
                            System.out.println(town + " plundered! " + gold + " gold stolen, " + population + " citizens killed.");
                            if (!city.hasResources()){
                                System.out.println(city.getName() + " has been wiped off the map!");
                                cities.remove(city);
                            }
                            break;
                        }
                    }
                    break;
                case "Prosper":
                    gold = Integer.parseInt(tokens[2].trim());
                    if (gold<0){
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }
                    for (City city : cities) {
                        if (city.getName().equals(town)){
                            city.setGold(city.getGold()+gold);
                            System.out.println(gold + " gold added to the city treasury. " + town + " now has " + city.getGold() + " gold.");
                        }
                    }
                    break;
            }
            event = scan.nextLine();
        }

        if (cities.size()>0){
            System.out.println("Ahoy, Captain! There are " + cities.size() + " wealthy settlements to go to:");
            cities.stream().sorted((c1, c2) -> {
                if (c2.getGold()>c1.getGold()){
                    return 1;
                }
                else if (c1.getGold()>c2.getGold()){
                    return -1;
                }
                else {
                    if (c1.getName().compareTo(c2.getName())>=0){
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
            }).forEach(c -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", c.getName(), c.getPopulation(), c.getGold()));

        }
    }
}

class City {
    String name;
    int population;
    int gold;

    City(String name, int p, int g) {
        this.name = name;
        this.population = p;
        this.gold = g;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getGold() {
        return gold;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void plunder(int p, int g) {
        this.population -= p;
        this.gold -= g;
    }

    public boolean hasResources() {
        return this.population > 0 && this.gold > 0;
    }
}
