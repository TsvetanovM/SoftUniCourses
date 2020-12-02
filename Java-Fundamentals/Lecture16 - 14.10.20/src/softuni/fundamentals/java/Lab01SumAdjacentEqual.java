package softuni.fundamentals.java;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab01SumAdjacentEqual {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numbers = inputToDoubleList(scan);

        int num = 0;
        while (num < numbers.size()-1) {
            if (numbers.get(num).equals(numbers.get(num+1))){
                numbers.set(num, numbers.get(num) + numbers.get(num+1));
                numbers.remove(num+1);
                num = 0;
//                if (num>0){
//                    if (numbers.get(num).equals(numbers.get(num-1))){
//                        num--;
//                    }
//                }
            }
            else {
                num++;
            }
        }
        System.out.println(printNonStringList(numbers, " "));
    }

    public static String printNonStringList(List<Double> numbers, String delimeter) {
        String output = "";
        for (Double number : numbers) {
            output += (new DecimalFormat("0.#").format(number)+delimeter);
        }
        return output;
    }

    public static List<Double> inputToDoubleList(Scanner scan) {
        String input = scan.nextLine();
        String[] tempArray = input.split(" ");
        List <Double> numbers = new ArrayList<>();
        for (String s : tempArray) {
            numbers.add(Double.parseDouble(s));
        }
        return numbers;
    }
}
