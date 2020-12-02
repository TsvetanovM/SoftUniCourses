package softuni.fundamentals.java;

        import java.util.Scanner;

public class Lab08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        char a = input.charAt(0);
        if (a>=65 && a<=90){
            System.out.println("upper-case");
        }
        else {
            System.out.println("lower-case");
        }
    }
}
