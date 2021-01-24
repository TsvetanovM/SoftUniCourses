import java.util.Arrays;
import java.util.Scanner;

public class Lab05MaxSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizes = scanner.nextLine().split(",\\s+");

        int[][] matrix = fillMatrix(sizes, scanner);

        int[][] subMatrix = new int[2][2];

        int biggestSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length-1; row++) {
            for (int col = 0; col < matrix[row].length-1; col++) {
                int sum = matrix[row][col]+matrix[row][col+1]+matrix[row+1][col]+matrix[row+1][col+1];
                if (sum>biggestSum) {
                    subMatrix[0][0] = matrix[row][col];
                    subMatrix[0][1] = matrix[row][col+1];
                    subMatrix[1][0] = matrix[row+1][col];
                    subMatrix[1][1] = matrix[row+1][col+1];
                    biggestSum = sum;
                }
            }
        }

        printMatrix(subMatrix);
        System.out.println(biggestSum);

    }

    private static void printMatrix(int[][] subMatrix) {
        for (int[] ints : subMatrix) {
            for (int j = 0; j < ints.length; j++) { // printing out the matrix.
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
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

