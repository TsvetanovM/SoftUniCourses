package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab04PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        passwordValidator(scan.nextLine());
    }

    static void passwordValidator (String password) {
        boolean isValid = true;
        boolean lettersAndDigits = true;
        if (password.length()<6 || password.length()>10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }
        int digitCounter = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (currentChar<48 || currentChar>122) {
                isValid = false;
                lettersAndDigits = false;
            }
            else if (currentChar>57 && currentChar<65){
                isValid = false;
                lettersAndDigits = false;
            }
            else if (currentChar>90 && currentChar<97) {
                isValid = false;
                lettersAndDigits = false;
            }
            if (currentChar>47 && currentChar<58) {
                digitCounter++;
            }
        }
        if (!lettersAndDigits) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (digitCounter<2) {
            isValid = false;
            System.out.println("Password must have at least 2 digits");
        }
        if (isValid) {
            System.out.println("Password is valid");
        }
    }
}
