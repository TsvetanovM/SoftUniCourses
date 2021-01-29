import java.util.Arrays;
import java.util.Scanner;

public class Lab05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sizeAsString = scanner.nextLine();

        while (invalidInput(sizeAsString)) {
            sizeAsString = scanner.nextLine();
        }
        int[] size = readArray(sizeAsString, "\\s+");
        String[][] matrix = readMatrix(size[0], size[1], scanner);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String command = input.substring(0, 4);
            if (!command.equals("swap")) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }
            input = input.replace("swap", "").trim();
            if (invalidInput(input)) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            boolean isValid = true;
            int[] coordinates = readArray(input, "\\s+");
            for (int number = 0; number < coordinates.length; number++) {
                if (number % 2 == 0) {
                    if (coordinates[number] >= matrix.length || coordinates[number] < 0) {
                        isValid = false;
                        break;
                    }
                } else {
                    if (coordinates[number] >= matrix[0].length || coordinates[number] < 0) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!isValid) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }
            String oldString = matrix[coordinates[0]][coordinates[1]];
            matrix[coordinates[0]][coordinates[1]] = matrix[coordinates[2]][coordinates[3]];
            matrix[coordinates[2]][coordinates[3]] = oldString;
            printMatrix(matrix);

            input = scanner.nextLine();
        }
    }

    private static boolean invalidInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!Character.isDigit(currentChar) && currentChar != ' ') {
                return true;
            }
        }
        return false;
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[] readArray(String string, String pattern) {
        return Arrays.stream(string.split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static String[][] readMatrix(int rows, int cols, Scanner scanner) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
