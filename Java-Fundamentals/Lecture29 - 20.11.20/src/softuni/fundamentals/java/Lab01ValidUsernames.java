package softuni.fundamentals.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab01ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> usernames = Arrays
                .stream(scan.nextLine().split(",\\s"))
                .collect(Collectors.toList());
        for (int i = 0; i < usernames.size(); i++) {
            boolean isValid = true;
            String username = usernames.get(i);
            if (username.length()<3 || username.length()>16){
                isValid = false;
            }
            char[] user = username.toCharArray();
            for (char c : user) {
                if (!Character.isLetterOrDigit(c)&&c!='-'&&c!='_'){
                    isValid = false;
                    break;
                }
            }
            if (!isValid) {
                usernames.remove(i);
                i--;
            }
        }
        usernames.forEach(System.out::println);
    }
}
