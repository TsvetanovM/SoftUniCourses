import java.util.*;
import java.util.function.Predicate;

public class Problem01_Cooking {
    private static final int BREAD = 25;
    private static final int CAKE = 50;
    private static final int PASTRY = 75;
    private static final int FRUIT_PIE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> cookedFoods = new TreeMap<>();
        fillMap(cookedFoods);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        int[] liquidNumbers = getInputAsIntArray(scanner);
        for (int number : liquidNumbers) {
            liquids.offer(number);
        }
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        int[] ingredientNumbers = getInputAsIntArray(scanner);
        for (int number : ingredientNumbers) {
            ingredients.push(number);
        }
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int ingredient = ingredients.pop();
            int value = liquids.poll() + ingredient;
            if (!cookFood(value, cookedFoods)) {
                ingredients.push(ingredient + 3);
            }
        }

        Predicate<Integer> foodChecker = e -> e >= 1;
        if (cookedFoods.size() == 4 && cookedFoods.values().stream().allMatch(foodChecker)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        printArrayDeque(liquids, "queue");
        printArrayDeque(ingredients, "stack");

        cookedFoods.forEach((k,v) -> System.out.println(k + ": " + v));
    }

    private static void fillMap(Map<String, Integer> cookedFoods) {
        cookedFoods.put("Bread", 0);
        cookedFoods.put("Cake", 0);
        cookedFoods.put("Pastry", 0);
        cookedFoods.put("Fruit Pie", 0);
    }

    private static void printArrayDeque(ArrayDeque<Integer> liquids, String type) {
        String phrase;
        if (type.equals("queue")){
            phrase = "Liquids left: ";
        } else {
            phrase = "Ingredients left: ";
        }
        if (liquids.isEmpty()) {
            System.out.println(phrase + "none");
        } else {
            if (type.equals("queue")) {
                System.out.print(phrase + liquids.poll());
            } else {
                System.out.print(phrase + liquids.pop());
            }
            for (Integer liquid : liquids) {
                System.out.print(", " + liquid);
            }
            System.out.println();
        }
    }

    private static int[] getInputAsIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean cookFood(int value, Map<String, Integer> map) {
        String food = "notFood";
        if (value == BREAD) {
            food = "Bread";
        } else if (value == CAKE) {
            food = "Cake";
        } else if (value == PASTRY) {
            food = "Pastry";
        } else if (value == FRUIT_PIE) {
            food = "Fruit Pie";
        }
        if (!food.equals("notFood")) {
            map.put(food, map.get(food) + 1);
            return true;
        }
        return false;
    }
}
