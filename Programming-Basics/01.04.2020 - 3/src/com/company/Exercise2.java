package com.company;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        //Напишете програма, която чете ъгъл в радиани (rad) и го преобразува в градуси (deg). Използвайте формулата:
        // градус = радиан * 180 / π.Числото π в Java програми е достъпно чрез Math.PI. Закръглете резултата до най-близкото цяло число използвайки "%.0f".
        Scanner scan = new Scanner(System.in);
        double rad = Double.parseDouble(scan.nextLine());
        double grad = rad * 180/ Math.PI;
        System.out.printf("%.0f", grad);
    }
}
