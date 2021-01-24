import java.util.Arrays;
import java.util.Scanner;

public class Lab01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols1 = readArray(scanner); // reading the matrix parameters - number of rows and columns// number of arrays and their size.

        int rows = rowsAndCols1[0];
        int cols = rowsAndCols1[1];

        int[][] matrix = new int[rows][cols]; //initializing a matrix - only number of arrays is a must - the first bracket value.

        fillMatrix(scanner, rows, matrix);

        int[] rowsAndCols2 = readArray(scanner);

        rows = rowsAndCols2[0];
        cols = rowsAndCols2[1];

        int[][] matrix2 = new int[rows][cols];

        fillMatrix(scanner, rows, matrix2);

        if (equalMatrices(matrix, matrix2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }


//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) { // printing out the matrix.
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    private static boolean equalMatrices(int[][] matrix, int[][] matrix2) {
        if (matrix.length!=matrix2.length) {
            return false;
        }
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row].length!=matrix2[row].length) {
                return false;
            }
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col]!=matrix2[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

//    private static boolean equalMatrices(int[][] matrix, int[][] matrix2) {
//        for (int row = 0; row < Integer.min(matrix.length, matrix2.length); row++) {
//            for (int col = 0; col < Integer.min(matrix[row].length, matrix2[row].length); col++) {
//                if (matrix[row][col]!= matrix2[row][col]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    private static void fillMatrix(Scanner scanner, int row, int[][] matrix) {
        for (int i = 0; i < row; i++) { //assigning values to the matrix
            matrix[i] = readArray(scanner);
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
