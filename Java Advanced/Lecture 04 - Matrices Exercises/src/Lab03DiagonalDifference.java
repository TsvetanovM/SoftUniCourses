import java.util.Arrays;
import java.util.Scanner;

public class Lab03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(n, scanner);

        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;
        int secondaryDiagonal = matrix[0].length-1;
        for (int row = 0; row < matrix.length; row++) {
            firstDiagonalSum += matrix[row][row];
            secondDiagonalSum += matrix[row][secondaryDiagonal--];
        }

        System.out.println(Math.abs(firstDiagonalSum-secondDiagonalSum));
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] readMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][rows];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }
        return matrix;
    }
}
