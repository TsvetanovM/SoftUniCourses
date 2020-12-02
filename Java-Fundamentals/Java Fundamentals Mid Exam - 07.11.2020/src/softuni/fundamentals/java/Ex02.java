package softuni.fundamentals.java;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] particles = scan.nextLine().split("\\|");
        String input = scan.nextLine();

        while (!input.equals("Done")) {
            String[] instructions = input.split("\\s");
            String command = instructions[0];
            String direction = instructions[1];
            switch (command) {
                case "Move":
                    int index = Integer.parseInt(instructions[2]);
                    switch (direction) {
                        case "Left":
                            if (index > 0 && index < particles.length) {
                                String placeHolder = particles[index];
                                particles[index] = particles[index - 1];
                                particles[index - 1] = placeHolder;
                            }
                            break;
                        case "Right":
                            if (index >= 0 && index < particles.length - 1) {
                                String placeHolder = particles[index];
                                particles[index] = particles[index + 1];
                                particles[index + 1] = placeHolder;
                            }
                            break;
                    }
                    break;
                case "Check":
                    switch (direction) {
                        case "Even":
                            for (int i = 0; i < particles.length; i+=2) {
                                if (i+2<particles.length) {
                                    System.out.print(particles[i] + " ");
                                }
                                else {
                                    System.out.print(particles[i]);
                                    System.out.println();
                                }
                            }
                            break;
                        case "Odd":
                            for (int i = 1; i < particles.length; i+=2) {
                                if (i+2<particles.length) {
                                    System.out.print(particles[i] + " ");
                                }
                                else {
                                    System.out.print(particles[i]);
                                    System.out.println();
                                }
                            }
                            break;
                    }
                    break;
            }
            input = scan.nextLine();
        }

        System.out.printf("You crafted %s!", String.join("", particles));
    }
}
