package InterfacesAndAbstraction;

import InterfacesAndAbstraction.BorderControl.Citizen;
import InterfacesAndAbstraction.BorderControl.Identifiable;
import InterfacesAndAbstraction.BorderControl.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Identifiable> entrants = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            Identifiable entrant = (tokens.length == 3) ?
                    new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]) :
                    new Robot(tokens[0], tokens[1]);
            entrants.add(entrant);
            input = scanner.nextLine();
        }

        String forDetention = scanner.nextLine();

        entrants.stream().filter(e -> e.getId().endsWith(forDetention))
                .forEach(e -> System.out.println(e.getId()));
    }
}
