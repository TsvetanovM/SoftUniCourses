import java.util.Arrays;
import java.util.Scanner;

public class Lab02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = readArray(scanner, "\\s+");
        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String entry = buildEntry(row, col);
                matrix[row][col] = entry;
            }
        }

        printMatrix(matrix);
    }

    private static String buildEntry(int row, int col) {
        char[] entry = {(char) (row+97), (char) (row+col+97), (char) (row+97)};
        StringBuilder toReturn = new StringBuilder();
        for (char c : entry) {
            toReturn.append(c);
        }
        return toReturn.toString();
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int number : arr) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String entry : arr) {
                System.out.print(entry + " ");
            }
            System.out.println();
        }
    }
}
