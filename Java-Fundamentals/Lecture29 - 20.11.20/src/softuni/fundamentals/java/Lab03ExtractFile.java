package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab03ExtractFile {
    public static void main(String[] args) {
        String fileLocation = new Scanner(System.in).nextLine();
        int startingIndex = fileLocation.lastIndexOf("\\");
        String[] file = fileLocation.substring(startingIndex+1).split("\\.");
        System.out.println("File name: " + file[0]);
        System.out.println("File extension: " + file[1]);
    }
}
