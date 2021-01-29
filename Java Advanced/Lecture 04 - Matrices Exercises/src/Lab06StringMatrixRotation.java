import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        int angle = 0;
        if (matcher.find()) {
            angle = Integer.parseInt(matcher.group());
        }
        String input = scanner.nextLine();
        List<String> matrixLines = new ArrayList<>();
        int maxLength = 0;
        while (!input.equals("END")) {
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            matrixLines.add(input);
            input = scanner.nextLine();
        }
        char[][] matrix = new char[matrixLines.size()][maxLength];

        for (int i = 0; i < matrixLines.size(); i++) {
            StringBuilder placeholder = new StringBuilder(matrixLines.get(i));
            while (placeholder.length() < maxLength) {
                placeholder.append(" ");
            }
            matrixLines.set(i, placeholder.toString());
            for (int col = 0; col < maxLength; col++) {
                matrix[i][col] = matrixLines.get(i).charAt(col);
            }
        }
        matrix = rotateMatrix(matrix, angle);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char[][] rotateMatrix(char[][] matrix, int angle) {
        int rotationAngle = angle % 360;

        if (rotationAngle == 0) {
            return matrix;
        }
        if (rotationAngle == 90) {
            char[][] newMatrix = new char[matrix[0].length][matrix.length];
            for (int row = 0; row < newMatrix.length; row++) {
                int oldMatrixRow = matrix.length - 1;
                for (int col = 0; col < newMatrix[0].length; col++) {
                    newMatrix[row][col] = matrix[oldMatrixRow--][row];
                }
            }
            return newMatrix;
        }
        if (rotationAngle == 180) {
            char[][] newMatrix = new char[matrix.length][matrix[0].length];
            int row = 0;
            for (int oldRow = matrix.length - 1; oldRow >= 0; oldRow--) {
                int col = 0;
                for (int oldCol = matrix[0].length - 1; oldCol >= 0; oldCol--) {
                    newMatrix[row][col++] = matrix[oldRow][oldCol];
                }
                row++;
            }
            return newMatrix;
        }
        char[][] newMatrix = new char[matrix[0].length][matrix.length];
        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix[0].length; col++) {
                newMatrix[row][col] = matrix[col][matrix[0].length - 1 - row];
            }
        }
        return newMatrix;
    }
}
