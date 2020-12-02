package softuni.fundamentals.java;

import java.util.*;
import java.util.stream.DoubleStream;

public class Lab07StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> classDiary = new LinkedHashMap<>();

        for (int i = 0; i<n; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            classDiary.putIfAbsent(name, new ArrayList<>());
            classDiary.get(name).add(grade);
        }

        Map<String, Double> finalGrades = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : classDiary.entrySet()) {
            double average = entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            finalGrades.put(entry.getKey(), average);
        }

        finalGrades.entrySet().stream()
                .filter(e -> e.getValue()>=4.50)
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));


//        classDiary.entrySet().stream()
//                .filter(e -> (e.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0)>=4.50))
//        .sorted((e1, e2) -> {
//            double grade2 = e2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
//            double grade1 = e1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
//            if (grade2>grade1){
//                return 1;
//            }
//            else {
//                return -1;
//            }
//        })
//        .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
