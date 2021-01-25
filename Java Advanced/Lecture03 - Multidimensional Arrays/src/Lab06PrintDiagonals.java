import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab06PrintDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String size = scanner.nextLine();
        int[][] matrix = fillMatrix(size, scanner);

        printFirstDiagonal(matrix);
        System.out.println();
        printSecondDiagonal(matrix);
    }

    private static void printFirstDiagonal(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }
    }

    private static void printSecondDiagonal(int[][] matrix) {
        int col = 0;
        for (int row = matrix.length-1; row >= 0; row--) {
            System.out.print(matrix[row][col] + " ");
            col++;
        }
    }

    private static int[][] fillMatrix(String[] sizes, Scanner scanner) {
        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }

        return matrix;
    }

    private static int[][] fillMatrix(String size, Scanner scanner) {
        int rows = Integer.parseInt(size);

        int[][] matrix = new int[rows][rows];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }

        return matrix;
    }

    private static int[] readArray(Scanner scanner, String pattern) {

        return Arrays.stream(scanner.nextLine()
                .split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void printDiagonals(int[][] matrix, String size) {

        int n = Integer.parseInt(size);
        int row = 0, col = n-1;

        while (row < n) {

            int innerRow = row;
            int innerCol = col;

            while (innerRow < n && innerCol < n) {
                System.out.print(matrix[innerRow++][innerCol++] + " ");
            }
            System.out.println();

            col--;
            if (col<0) {
                col = 0;
                row++;
            }
        }
    }
}
