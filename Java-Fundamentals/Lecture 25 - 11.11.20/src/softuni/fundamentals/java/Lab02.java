package softuni.fundamentals.java;

import java.util.*;

public class Lab02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i<n; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();
//            List<String> synonyms = new ArrayList<>();
            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
//            if (words.containsKey(word)) {
//                synonyms = words.get(word);
//            }
////            if (!synonyms.contains(synonym)) {
//            synonyms.add(synonym);
//////            }
//            words.put(word, synonyms);
           }
        for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
//            System.out.print(entry.getKey()+ " - ");
//            System.out.println(String.join(", ", entry.getValue()));
        }
    }
}
