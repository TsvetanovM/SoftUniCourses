package com.company;

import java.util.Scanner;

public class Exer6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //3 домашни любимеца (куче, котка и костенурка)
        int Days = Integer.parseInt(scan.nextLine());
        int Food = Integer.parseInt(scan.nextLine());
        double DogFood = Double.parseDouble(scan.nextLine());
        double CatFood = Double.parseDouble(scan.nextLine());
        double TurtleFood = Double.parseDouble(scan.nextLine());

        double FoodPerDay = DogFood + CatFood + TurtleFood/1000;
        double NeededFood = FoodPerDay * Days;

        if (NeededFood>Food){
            NeededFood = NeededFood - Food;
            NeededFood = Math.ceil(NeededFood);
            System.out.printf("%.0f more kilos of food are needed.", NeededFood);
        }
        else {
            double ExtraFood = Food - NeededFood;
            ExtraFood = Math.floor(ExtraFood);
            System.out.printf("%.0f kilos of food left.", ExtraFood);
        }
    }
}
