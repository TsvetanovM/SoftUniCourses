import java.util.Arrays;
import java.util.Scanner;

public class Lab07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessBoard = fillMatrix(scanner);

        boolean isFound = false;

        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard[row].length; col++) {
                if (chessBoard[row][col].equals("q")) {
                   if (isTheValidQueen(chessBoard, row, col)) {
                       System.out.println(row + " " + col);
                       isFound = true;
                       break;
                   }
                }
            }
            if (isFound) {
                break;
            }
        }
    }

    private static boolean isTheValidQueen(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < matrix.length; row++) {
            if (row==rows){
                continue;
            }
            if (matrix[row][cols].equals("q")){
                return false;
            }
        }

        for (int col = 0; col < matrix[rows].length; col++) {
            if (col==cols){
                continue;
            }
            if (matrix[rows][col].equals("q")){
                return false;
            }
        }

        int col1 = cols;
        int col2 = cols;
        for (int row = rows-1; row >= 0; row--) {
            col1--;
            col2++;
            if (col1>=0 && matrix[row][col1].equals("q")){
                    return false;
            }

            if (col2<matrix[row].length && matrix[row][col2].equals("q")) {
                    return false;
            }

        }

        col1 = cols;
        col2 = cols;
        for (int row = rows+1; row < matrix.length; row++) {
            col1--;
            col2++;

            if (matrix[row][col1].equals("q")||matrix[row][col2].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static String[][] fillMatrix(Scanner scanner) {
        String[][] matrix = new String[8][8];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }

        return matrix;
    }

    private static int[] readArray(Scanner scanner, String pattern) {

        return Arrays.stream(scanner.nextLine()
                .split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static String[] readArray(Scanner scanner) {

        return scanner.nextLine().split("\\s+");
    }
}
