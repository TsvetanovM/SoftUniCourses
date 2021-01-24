import java.util.Arrays;
import java.util.Scanner;

public class Lab02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }

        int numberToFind = Integer.parseInt(scanner.nextLine());

        boolean notFound = true;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == numberToFind) {
                    System.out.println(row + " " + col);
                    notFound = false;
                }
            }
        }

        if (notFound) {
            System.out.println("not found");
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
