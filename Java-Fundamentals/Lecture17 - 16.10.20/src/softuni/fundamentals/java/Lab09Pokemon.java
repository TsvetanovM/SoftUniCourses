package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab09Pokemon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> pokemons = toIntegerList(scan);
        int pokemonValue = 0;
        while (!pokemons.isEmpty()) {
            int input = scan.nextInt();
            int currentValue;
            if (input<0){
                currentValue = pokemons.get(0);
                pokemons.remove(0);
                pokemons.add(0, pokemons.get(pokemons.size()-1));
            }
            else if (input>=pokemons.size()){
                currentValue = pokemons.get(pokemons.size()-1);
                pokemons.remove(pokemons.size()-1);
                pokemons.add(pokemons.size(), pokemons.get(0));
            }
            else {
                currentValue = pokemons.get(input);
                pokemons.remove(input);
            }
            pokemonValue+=currentValue;
            for (int i = 0; i < pokemons.size(); i++) {
                if (pokemons.get(i)<=currentValue){
                    pokemons.set(i, pokemons.get(i)+currentValue);
                }
                else {
                    pokemons.set(i, pokemons.get(i)-currentValue);
                }
            }
        }
        System.out.println(pokemonValue);
    }

    private static List<Integer> toIntegerList(Scanner scan) {
        String input = scan.nextLine();
        String[] array = input.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String s: array) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }
}
