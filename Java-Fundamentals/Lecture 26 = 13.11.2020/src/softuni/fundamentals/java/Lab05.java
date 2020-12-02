package softuni.fundamentals.java;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, String> parkingManager = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] message = scan.nextLine().split(" ");
            String command = message[0];
            String user = message[1];

            switch (command){
                case "register":
                    String licensePlate = message[2];
                    if (!parkingManager.containsKey(user)){
                        parkingManager.put(user, licensePlate);
                        System.out.println(user + " registered " + licensePlate + " successfully");
                    }
                    else {
//                        if (!licensePlate.equals(parkingManager.get(user))){
                            System.out.println("ERROR: already registered with plate number " + parkingManager.get(user));
//                        }
                    }
                    break;
                case "unregister":
                    if (!(parkingManager.containsKey(user))){
                        System.out.println("ERROR: user " + user  + " not found");
                    }
                    else {
                        parkingManager.remove(user);
                        System.out.println(user + " unregistered successfully");
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> entry : parkingManager.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}
