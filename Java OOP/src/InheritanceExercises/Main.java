package InheritanceExercises;

import InheritanceExercises.hero.*;
import InheritanceExercises.person.Child;
import InheritanceExercises.zoo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DarkWizard dw = new DarkWizard("Marto", 100);

        System.out.println(dw.toString());
     }
}
