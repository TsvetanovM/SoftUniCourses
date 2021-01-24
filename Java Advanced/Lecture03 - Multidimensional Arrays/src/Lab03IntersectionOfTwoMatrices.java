import java.util.Arrays;
import java.util.Scanner;

public class Lab03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[M][N];
        char[][] secondMatrix = new char[M][N];
        char[][] thirdMatrix = new char[M][N];

        fillMatrix(scanner, firstMatrix);
        fillMatrix(scanner, secondMatrix);

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                char current = firstMatrix[row][col];
                if (current != secondMatrix[row][col]) {
                    thirdMatrix[row][col] = '*';
                } else {
                    thirdMatrix[row][col] = current;
                }
            }
        }

        for (char[] row : thirdMatrix) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, char[][] firstMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            StringBuilder input = new StringBuilder();
            for (String s : tokens) {
                input.append(s);
            }
            firstMatrix[row] = input.toString().toCharArray();
        }
    }
}
