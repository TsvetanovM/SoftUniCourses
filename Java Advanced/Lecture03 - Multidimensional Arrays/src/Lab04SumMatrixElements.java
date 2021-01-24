import java.util.Arrays;
import java.util.Scanner;

public class Lab04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizes = scanner.nextLine().split(",\\s+");

        int[][] matrix = fillMatrix(sizes, scanner);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        long sum = 0L;

        for (int[] row : matrix) {
            for (int col : row) {
                sum += col;
            }
        }

        System.out.println(sum);

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] fillMatrix(String[] sizes, Scanner scanner) {
        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }

        return matrix;
    }
}
