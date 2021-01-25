import java.util.Arrays;
import java.util.Scanner;

public class Lab08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();

        int[][] matrix = fillMatrix(size, scanner);

        int[] wrongValues = readArray(scanner, "\\s+");
        int rowPosition = wrongValues[0];
        int colPosition = wrongValues[1];

        int wrongMeasurement = matrix[rowPosition][colPosition];

        int[][] finalMatrix = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col]==wrongMeasurement) {
                     int rightMeasurement = getRightMeasurement(matrix, row, col, wrongMeasurement);
                     finalMatrix[row][col] = rightMeasurement;
                     continue;
                }
                finalMatrix[row][col] = matrix[row][col];
            }
        }

        printMatrix(finalMatrix);
    }

    private static int getRightMeasurement(int[][] matrix, int row, int col, int wrongMeasurement) {
        int rightMeasurement = 0;

        int currentNumber;
        if (row-1>=0) {
            currentNumber = matrix[row-1][col];
            rightMeasurement = validateNumber(wrongMeasurement, rightMeasurement, currentNumber);
        }
        if (col-1>=0) {
            currentNumber = matrix[row][col-1];
            rightMeasurement = validateNumber(wrongMeasurement, rightMeasurement, currentNumber);
        }
        if (col+1<matrix[row].length) {
            currentNumber = matrix[row][col+1];
            rightMeasurement = validateNumber(wrongMeasurement, rightMeasurement, currentNumber);
        }

        if (row+1<matrix.length) {
            currentNumber = matrix[row+1][col];
            rightMeasurement = validateNumber(wrongMeasurement, rightMeasurement, currentNumber);
        }

        return rightMeasurement;
    }

    private static int validateNumber(int wrongMeasurement, int rightMeasurement, int currentNumber) {
        if (currentNumber != wrongMeasurement) {
            rightMeasurement += currentNumber;
        }
        return rightMeasurement;
    }

    private static int[][] fillMatrix(String size, Scanner scanner) {
        int rows = Integer.parseInt(size);

        int[][] matrix = new int[rows][];

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

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) { // printing out the matrix.
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
