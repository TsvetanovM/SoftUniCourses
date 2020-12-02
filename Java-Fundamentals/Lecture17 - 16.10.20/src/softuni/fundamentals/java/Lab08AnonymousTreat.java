package softuni.fundamentals.java;

import java.util.*;

public class Lab08AnonymousTreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<String> list = new LinkedList<>(Arrays.asList(input.split(" +")));
        String[] currentInput = inputConversion(scan);
        while (!currentInput[0].equals("3:1")) {
            switch (currentInput[0]){
                case "merge":
                    int startIndex = Integer.parseInt(currentInput[1]);
                    int endIndex = Integer.parseInt(currentInput[2]);
                    if (startIndex<0 && endIndex>=list.size()||startIndex>=list.size()||endIndex<0){
                        break;
                    }
                    String futureValue = "";
                    int counter = 0;
                    if (endIndex<list.size()){
                        if (startIndex>=0) {
                            counter = startIndex;
                        }
                        else {
                            startIndex = 0;
                        }
                        while (counter<=endIndex){
                                futureValue += list.get(startIndex);
                                list.remove(startIndex);
                                counter++;
                        }
                    }
                    else {
                        while (startIndex<list.size()){
                            futureValue += list.get(startIndex);
                            list.remove(startIndex);
                        }
                    }
                    list.add(startIndex, futureValue);
                    break;
                case "divide":
                    int index = Integer.parseInt(currentInput[1]);
                    int partitions = Integer.parseInt(currentInput[2]);
                    if (partitions>list.get(index).length()){
                        partitions = list.get(index).length();
                    }
                    if (partitions==0){
                        break;
                    }
                    int charsInGroup = list.get(index).length()/partitions;
                    int leftover = list.get(index).length()%partitions;
                    List<String> particles = new ArrayList<>();
                    int j = 0;
                    for (int i = 0; i<partitions; i++) {
                        particles.add(list.get(index).substring(j, j+charsInGroup));
                        j+=charsInGroup;
                    }
                    if (leftover!=0){
                        int finish = list.get(index).length();
                        String temp = particles.get(particles.size()-1);
                        temp += list.get(index).substring(finish-leftover, finish);
                        particles.set(particles.size()-1, temp);
                    }
                    list.remove(index);
                    for (int i = particles.size() - 1; i >= 0; i--) {
                        list.add(index, particles.get(i));
                    }
            }
            currentInput = inputConversion(scan);
        }
//        for (String s : list) {
//            System.out.print(s+" ");
//        }
        System.out.println(String.join(" ", list.toString()).replaceAll("[\\[\\],]", ""));
    }

    private static String[] inputConversion(Scanner scanner) {
        String input = scanner.nextLine();
        return input.split(" ");
    }
}
