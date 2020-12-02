package softuni.fundamentals.java;

import java.util.*;

public class Lab03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        Map<String, Integer> elementsCounter = new LinkedHashMap<>();

        for (String s : input) {
            String element = s.toLowerCase();
            Integer count = elementsCounter.get(element);
            if (count == null) {
                count = 0;
            }
            elementsCounter.put(element, count + 1);
        }

        List<String> validElements = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : elementsCounter.entrySet()) {
            if (entry.getValue()%2!=0){
                validElements.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", validElements));
    }
}
