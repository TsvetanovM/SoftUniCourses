package softuni.fundamentals.java;

import java.util.*;

public class Lab03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> legendaryResources = new TreeMap<>();
        legendaryResources.put("shards", 0);
        legendaryResources.put("fragments", 0);
        legendaryResources.put("motes", 0);
        Map<String, Integer> trashResources = new TreeMap<>();

        boolean legendaryObtained = false;
        String legendaryName = "";

        while (!legendaryObtained){
            String[] input = scan.nextLine().split("\\s+");
            for (int i = 0; i < input.length-1; i+=2) {
                String resource = input[i+1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);
                if (legendaryResources.containsKey(resource)){
                    int previousQuantity = legendaryResources.get(resource);
                    legendaryResources.put(resource, previousQuantity+quantity);
                    if (legendaryResources.get(resource)>=250){
                        legendaryObtained = true;
                        switch (resource){
                            case "shards":
                                legendaryName = "Shadowmourne";
                                break;
                            case "fragments":
                                legendaryName = "Valanyr";
                                break;
                            case "motes":
                                legendaryName = "Dragonwrath";
                                break;
                        }
                        legendaryResources.put(resource, previousQuantity+quantity-250);
                        break;
                    }
                }
                else {
                  Integer previousQuantity = trashResources.get(resource);
                  if (previousQuantity==null){
                      previousQuantity = 0;
                  }
                  trashResources.put(resource, previousQuantity+quantity);
                }
            }
        }
        System.out.println(legendaryName + " obtained!");
        legendaryResources.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        for (Map.Entry<String, Integer> entry : trashResources.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
