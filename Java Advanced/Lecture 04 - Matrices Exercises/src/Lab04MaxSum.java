import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab04MaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = readArray(scanner, "\\s+");

        int[][] matrix = readMatrix(size[0], size[1], scanner);

        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                int currentSum = 0;
                currentSum += matrix[row][col] + matrix[row][col+1] + matrix[row][col+2]
                        + matrix[row+1][col] + matrix[row+1][col+1] + matrix[row+1][col+2]
                        + matrix[row+2][col] + matrix[row+2][col+1] + matrix[row+2][col+2];
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);

        for (int i = maxRow; i < maxRow+3; i++) {
            for (int j = maxCol; j < maxCol+3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }
        return matrix;
    }
}
