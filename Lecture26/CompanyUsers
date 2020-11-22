package softuni.fundamentals.java;

import java.util.*;

public class Lab08CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> companyUsers = new TreeMap<>();

        while (!input.equals("End")){
            String[] currentLine = input.split("->");
            String company = currentLine[0];
            String employee = currentLine[1];
            companyUsers.putIfAbsent(company, new ArrayList<>());
            boolean alreadyExists = false;
            for (String s : companyUsers.get(company)) {
                if (s.equals(employee)){
                    alreadyExists = true;
                    break;
                }
            }
            if (!alreadyExists){
                companyUsers.get(company).add(employee);
            }
            input = scan.nextLine();
        }

//        companyUsers.forEach((key, value) -> {
//            System.out.println(key);
//            for (String s : value) {
//                System.out.println("--" + s);
//            }
//        });

        companyUsers.forEach((a, b) -> {
            System.out.println(a);
            for (String s : b) {
                System.out.println("--" + s);
            }
        });
    }
}
