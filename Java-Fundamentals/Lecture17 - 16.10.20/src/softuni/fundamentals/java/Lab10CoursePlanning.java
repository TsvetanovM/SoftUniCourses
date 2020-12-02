package softuni.fundamentals.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lab10CoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String initialInput = scan.nextLine();
        List<String> lessons = new LinkedList<>(Arrays.asList(initialInput.split(", ")));
        String[] input = currentInput(scan);
        while (!input[0].equals("course start")) {
            String currentLesson = input[1];
            int lessonCheck = lessons.indexOf(currentLesson);
            switch (input[0]){
                case "Add":
                    lessonCheck = lessons.indexOf(currentLesson);
                    if (lessonCheck>-1) {
                        break;
                    }
                    else {
                        lessons.add(currentLesson);
                    }
                    break;
                case "Insert":
                    if (lessonCheck>-1){
                        break;
                    }
                    else {
                        lessons.add(Integer.parseInt(input[2]), currentLesson);
                    }
                    break;
                case "Remove":
                    if (lessonCheck<0){
                        break;
                    }
                    else {
                        lessons.remove(lessonCheck);
                        currentLesson+="-Exercise";
                        lessonCheck = lessons.indexOf(currentLesson);
                        if (lessonCheck<0){
                            break;
                        }
                        else {
                            lessons.remove(lessonCheck);
                        }
                    }
                    break;
                case "Swap":
                     if (lessonCheck>-1){
                         if (lessons.contains(input[2])){
                             int secondIndex = lessons.indexOf(input[2]);
                             String secondLesson = lessons.get(secondIndex);
                             lessons.set(secondIndex, currentLesson);
                             lessons.set(lessonCheck, secondLesson);
                             currentLesson+="-Exercise";
                             secondLesson+="-Exercise";
                             if (lessons.contains(currentLesson)) {
                                 lessons.remove(lessonCheck+1);
                                 lessons.add(secondIndex + 1, currentLesson);
                             }
                             if (lessons.contains(secondLesson)) {
                                     lessons.remove(secondIndex + 1);
                                     lessons.add(lessonCheck + 1, secondLesson);
                             }
                         }
                     }
                    break;
                case "Exercise":
                    if (lessonCheck>-1){
                        currentLesson+="-Exercise";
                        if (lessons.contains(currentLesson)){
                            break;
                        }
                        lessons.add(lessonCheck+1, currentLesson);
                    }
                    else {
                        lessons.add(currentLesson);
                        currentLesson+="-Exercise";
                        lessons.add(currentLesson);
                    }
                    break;
            }
            input = currentInput(scan);
        }
        for (int i = 0; i < lessons.size(); i++) {
            System.out.printf("%d.%s%n",i+1,lessons.get(i));
        }
//        for (String lesson : lessons) {
//            System.out.println(lesson.toString().replaceAll(", ", ""));
//        }
    }

    public static String[] currentInput(Scanner scanner) {
        String input = scanner.nextLine();
        return input.split(":");
    }
}
