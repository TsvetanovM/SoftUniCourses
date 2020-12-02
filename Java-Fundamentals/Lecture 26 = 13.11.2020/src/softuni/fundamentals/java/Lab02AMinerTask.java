package softuni.fundamentals.java;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab02AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String resource = scan.nextLine();
        Map<String, Long> stash = new LinkedHashMap<>();

        while (!resource.equals("stop")){
            String quantity = scan.nextLine();
//            if (!quantity.equals("stop")){
                Long previousQuantity = stash.get(resource);
                if (previousQuantity==null){
                    previousQuantity = 0L;
                }
                stash.put(resource, previousQuantity+Long.parseLong(quantity));
                resource = scan.nextLine();
//            }
//            else {
//                break;
//            }
        }

        for (Map.Entry<String, Long> entry : stash.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
