import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = parseIntArray(scanner.nextLine());
        int x = dimensions[0];
        int y = dimensions[1];

        matrix = new int[x][y];

        int value = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = value++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoStartingPosition = parseIntArray(command);
            int[] evilStartingPosition = parseIntArray(scanner.nextLine());
            int evilRow = evilStartingPosition[0] - 1;
            int evilCol = evilStartingPosition[1] - 1;

            while (isWithinMatrix(evilRow, evilCol)) {
                matrix[evilRow][evilCol] = 0;
                evilRow--;
                evilCol--;
            }

            int ivoRow = ivoStartingPosition[0] - 1;
            int ivoCol = ivoStartingPosition[1] + 1;

            while (isWithinMatrix(ivoRow, ivoCol)) {
                sum += matrix[ivoRow][ivoCol];
                ivoCol++;
                ivoRow--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);

    }

    private static boolean isWithinMatrix(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static int[] parseIntArray(String s) {
        return Arrays.stream(s.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
