package com.company;

import java.util.Scanner;

public class Lab2MoreExercises {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int period = Integer.parseInt(scan.nextLine());
        int doctors = 7;
        int treatedPatients = 0;
        int untreatedPatients = 0;

        for (int i =1; i<=period; i++){
            if (i%3==0){
                if (treatedPatients<untreatedPatients){
                    doctors+=1;
                }
            }
            int patients = Integer.parseInt(scan.nextLine());
            if (patients<=doctors){
                treatedPatients+= patients;
            }
            else {
                treatedPatients+=doctors;
                untreatedPatients+=patients-doctors;
            }
        }
        System.out.printf("Treated patients: %d.%nUntreated patients: %d.", treatedPatients, untreatedPatients);
    }
}
