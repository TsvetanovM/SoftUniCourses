import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    private static int row;
    private static int column;
    private static String[][] bombField;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> commands = Arrays.stream(scanner.nextLine().split(","))
                .collect(Collectors.toCollection(ArrayDeque::new));
        bombField = new String[n][n];
        for (int i = 0; i < bombField.length; i++) {
            bombField[i] = scanner.nextLine().split("\\s+");
        }
        findCurrentPosition("s");
        int activeBombs = bombsCount();
        String currentSymbol = "";
        while (activeBombs > 0 && !commands.isEmpty()) {
            movePosition(commands.poll());
            currentSymbol = bombField[row][column];
            if (isEndOfTheRoute(currentSymbol)) {
                break;
            }
            if ("B".equals(currentSymbol)) {
                activeBombs--;
                System.out.println("You found a bomb!");
                setPositionAsVisited();
            }
        }
        String output = "";
        if (activeBombs == 0) {
            output = "Congratulations! You found all bombs!";
        } else if (isEndOfTheRoute(currentSymbol)) {
            output = "END! " + activeBombs + " bombs left on the field";
        } else {
            output = String.format("%d bombs left on the field. Sapper position: (%d,%d)",
                    activeBombs, row, column);
        }

        System.out.println(output);
    }

    private static int bombsCount() {
        int bombCount = 0;
        for (String[] strings : bombField) {
            for (String string : strings) {
                if (string.equals("B")) bombCount++;
            }
        }
        return bombCount;
    }

    private static boolean isEndOfTheRoute(String currentSymbol) {
        return currentSymbol.equals("e");
    }

    private static void setPositionAsVisited() {
        bombField[row][column] = "+";
    }

    private static void findCurrentPosition(String symbol) {
        boolean areSet = false;
        for (int i = 0; i < bombField.length; i++) {
            for (int j = 0; j < bombField[i].length; j++) {
                if (bombField[i][j].equals(symbol)) {
                    row = i;
                    column = j;
                    areSet = true;
                    break;
                }
            }
            if (areSet) break;
        }
    }

    private static void movePosition(String command) {
        switch (command) {
            case "up":
                if (row != 0) row = row - 1;
                break;
            case "down":
                if (row != bombField.length-1) row = row + 1;
                break;
            case "left":
                if (column != 0) column = column - 1;
                break;
            case "right":
                if (column != bombField.length-1) column = column + 1;
                break;
        }
    }
}
