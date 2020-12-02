package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab10PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingPokePower = Integer.parseInt(scan.nextLine());
        int pokePower = startingPokePower;
        int distance = Integer.parseInt(scan.nextLine());
        int exhaustionFactor = Integer.parseInt(scan.nextLine());
        int pokeCounter = 0;

        while (pokePower>=distance){
            pokePower-=distance;
            pokeCounter++;
            if (pokePower*2==startingPokePower){
                    pokePower = pokePower/exhaustionFactor;
            }
        }
        System.out.println(pokePower);
        System.out.println(pokeCounter);
    }
}
