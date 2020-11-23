package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab07StringExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scan.nextLine());
        int explosionStart = input.indexOf(">");

        while (explosionStart != -1) {
            boolean finish = false;
            int firstBomb = explosionStart+1;
            int explosionPower = input.charAt(firstBomb)-48;

            while (explosionPower>0){
                if (firstBomb==input.length()){
                    finish = true;
                    break;
                }
                char current = input.charAt(firstBomb);
                if (current!='>'){
                    input.deleteCharAt(firstBomb);
                    explosionPower--;
                }
                else {
                    explosionPower += input.charAt(firstBomb+1)-48;
                    firstBomb++;
                }
            }
            if (finish){
                break;
            }
            explosionStart = input.indexOf(">", firstBomb);
        }
        System.out.println(input.toString());
    }
}
