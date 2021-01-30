import java.util.Arrays;
import java.util.Scanner;

public class Lab07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = readArray(scanner, "\\s+");
        String[][] matrix = readMatrix(size[0],size[1], scanner);
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int[] boomCoordinates = readArray(command, "\\s+");
            if (boomCoordinates[0]>=matrix.length || boomCoordinates[0]<0 || boomCoordinates[1]>=matrix[0].length || boomCoordinates[1]<0) {
                command = scanner.nextLine();
                continue;
            }
            int radius = boomCoordinates[2];
            for (int row = boomCoordinates[0]-radius; row <= boomCoordinates[0]+radius; row++) {
                if (row<0) {
                    row = 0;
                }
                if (row>=matrix.length) {
                    break;
                }
                matrix[row][boomCoordinates[1]] = "";
            }
            for (int col = boomCoordinates[1]-radius; col <= boomCoordinates[1]+radius; col++) {
                if (col<0) {
                    col = 0;
                }
                if (col>=matrix[0].length) {
                    break;
                }
                matrix[boomCoordinates[0]][col] = "";
            }
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    if (matrix[row][col].equals("")) {
                        int cols = col;
                        while (matrix[row][cols].equals("")) {
                            cols++;
                            if (cols == matrix[0].length) {
                                cols = col;
                                break;
                            }
                        }
                        String newValue = matrix[row][cols];
                        matrix[row][col] = newValue;
                        matrix[row][cols] = "";
                    }
                }
            }

            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[] readArray(String string, String pattern) {
        return Arrays.stream(string.split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static String[][] readMatrix(int rows, int cols, Scanner scanner) {
        String[][] matrix = new String[rows][cols];
        int n = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = String.valueOf(n++);
            }
        }
        return matrix;
    }
    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String s : arr) {
                if (s.equals("")) {
                    continue;
                }
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

}
