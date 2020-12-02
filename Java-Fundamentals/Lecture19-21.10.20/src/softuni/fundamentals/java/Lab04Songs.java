package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab04Songs {
    String typeList, name, time;

    Lab04Songs(String type, String name, String time) {
        this.typeList = type;
        this.name = name;
        this.time = time;
    }

     String getTypeList() {
        return this.typeList;
    }

    String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        Lab04Songs[] collection = new Lab04Songs[N];
        for (int i = 0; i < N; i++) {
            String[] input = scan.nextLine().split("_");
            collection[i] = new Lab04Songs(input[0], input[1], input[2]);
        }
        String print = scan.nextLine();
        if (!print.equals("all")){
            for (Lab04Songs song : collection) {
                if (song.getTypeList().equals(print)) {
                    System.out.println(song.getName());
                }
            }
        }
        else {
            for (Lab04Songs song : collection) {
                System.out.println(song.getName());
            }
        }
    }
}
