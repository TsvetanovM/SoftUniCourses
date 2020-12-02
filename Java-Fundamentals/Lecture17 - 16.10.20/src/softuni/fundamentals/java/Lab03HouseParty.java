package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab03HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int commands = Integer.parseInt(scan.nextLine());
        List<String> guestList = new ArrayList<>();
        for (int i = 0; i < commands; i++) {
            String input = scan.nextLine();
            String[] currentGuest = input.split(" ");
            int onList = guestList.indexOf(currentGuest[0]);
            if (input.contains("not going")){
                if (onList>=0) {
                    guestList.remove(onList);
                }
                else {
                    System.out.printf("%s is not in the list!%n", currentGuest[0]);
                }
            }
            else {
                if (onList>=0){
                    System.out.printf("%s is already in the list!%n", currentGuest[0]);
                }
                else {
                    guestList.add(currentGuest[0]);
                }
            }
        }
        for (String guest:guestList) {
            System.out.println(guest);
        }
    }
}
