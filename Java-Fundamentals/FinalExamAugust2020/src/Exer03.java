import java.util.*;

public class Exer03 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Plant> plants = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("<->");
            String plantName = info[0];
            int rarity = Integer.parseInt(info[1]);
            plants.putIfAbsent(plantName, new Plant(plantName, rarity));
            plants.get(plantName).setRarity(rarity);
        }

        String input = scan.nextLine();

        while (!input.equals("Exhibition")) {
            if (!input.contains(": ")){
                System.out.println("error");
                input = scan.nextLine();
                continue;
            }
            boolean isValid = true;
            String[] tokens = input.split(": ");
            String command = tokens[0];
            switch (command) {
                case "Rate":
                    if (!tokens[1].contains(" - ")){
                        System.out.println("error");
                        break;
                    }
                    String[] rate = tokens[1].split(" - ");
                    String plantName = rate[0];
                    if (plants.get(plantName)==null){
                        isValid = false;
                        break;
                    }
                    for (int i = 0; i < rate[1].length(); i++){
                        char current = rate[1].charAt(i);
                        if (!Character.isDigit(current)&&current!='.'){
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid) {
                        double rating = Double.parseDouble(rate[1]);
                        plants.get(plantName).addRating(rating);
                    }
                    break;
                case "Update":
                    if (!tokens[1].contains(" - ")){
                        System.out.println("error");
                        break;
                    }
                    rate = tokens[1].split(" - ");
                    plantName = rate[0];
                    if (plants.get(plantName)==null){
                        isValid = false;
                        break;
                    }
                    for (int i = 0; i < rate[1].length(); i++){
                        char current = rate[1].charAt(i);
                        if (!Character.isDigit(current)){
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid) {
                        plants.get(plantName).setRarity(Integer.parseInt(rate[1]));
                    }
                    break;
                case "Reset":
                    if (plants.get(tokens[1])==null){
                        isValid = false;
                        break;
                    }
                    plants.get(tokens[1]).resetRating();
                    break;

                default:
                    System.out.println("error");
                    break;

            }
            if (!isValid){
                System.out.println("error");
            }
            input = scan.nextLine();
        }

        for (Map.Entry<String, Plant> entry : plants.entrySet()) {
            entry.getValue().findAverage();
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet().stream().sorted((p1, p2) -> Double.compare(p2.getValue().getAverageRating(), p1.getValue().getAverageRating()))
                .sorted((p1, p2) -> Integer.compare(p2.getValue().getRarity(), p1.getValue().getRarity()))
                .forEach(p -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", p.getValue().getName(), p.getValue().getRarity(), p.getValue().getAverageRating()));

    }
}

class Plant {
    String name;
    int rarity;
    List<Double> rating = new ArrayList<>();
    double averageRating;

    Plant(String n, int r) {
        this.name = n;
        rarity = r;
    }

    public String getName() {
        return name;
    }

    public int getRarity() {
        return rarity;
    }

    public List<Double> getRating() {
        return rating;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public void addRating(double rating) {
        getRating().add(rating);
    }

    public void resetRating() {
        this.rating.clear();
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void findAverage() {
        double sum = 0;
        for (Double aDouble : getRating()) {
            sum += aDouble;
        }
        if (sum==0){
            this.averageRating = 0;
        }
        else {
            this.averageRating = sum / getRating().size();
        }
    }
}
