import java.util.Arrays;
import java.util.Scanner;

public class Lab01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int n = Integer.parseInt(input[0]);
        String matrixType = input[1];

        int[][] matrix = new int[n][n];

        if (matrixType.equals("A")) {
            readMatrixA(matrix);
        } else {
            readMatrixB(matrix);
        }
        printMatrix(matrix);
    }

    private static void readMatrixB(int[][] matrix) {
        int nextNumber = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            if (col%2==0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = nextNumber++;
                }
            } else {
                for (int row = matrix.length-1; row >= 0; row--) {
                    matrix[row][col] = nextNumber++;
                }
            }
        }
    }

    private static void readMatrixA(int[][] matrix) {
        int nextNumber = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = nextNumber++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int number : arr) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }


}
