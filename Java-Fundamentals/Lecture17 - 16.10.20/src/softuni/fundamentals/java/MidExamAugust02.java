package softuni.fundamentals.java;

import java.util.Arrays;
import java.util.Scanner;

public class MidExamAugust02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scan.nextLine());
        int[] lift = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer ::parseInt).toArray();
            for (int i = 0; i < lift.length; i++) {
                int spaceInWagon = 4 - lift[i];
                if (spaceInWagon==0) {
                    continue;
                }
                if (spaceInWagon<=peopleWaiting) {
                    peopleWaiting -= spaceInWagon;
                    lift[i] += spaceInWagon;
                }
                else {
                    lift[i] += peopleWaiting;
                    peopleWaiting = 0;
                }
                if (peopleWaiting==0) {
                    break;
                }
            }
        if (peopleWaiting==0){
            boolean isFull = true;
            for (int i : lift) {
                if (i!=4){
                    isFull = false;
                    break;
                }
            }
            if (!isFull) {
                System.out.println("The lift has empty spots!");
            }
        }
        else {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }
        printArray(lift);
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
