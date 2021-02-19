import java.util.Scanner;

public class Snake {
    private static int food = 0;
    private static int row = 0;
    private static int column = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] territory = new String[n][n];
        for (int i = 0; i < territory.length; i++) {
            territory[i] = scanner.nextLine().split("");
        }
        findCurrentPosition(territory, "S");
        while (food < 10) {
            String command = scanner.nextLine();
            movePosition(command, territory);
            if (invalidPosition(territory)) {
                break;
            }
            String positionValue = territory[row][column];
            switch (positionValue) {
                case "*":
                    food++;
                    break;
                case "B":
                    setPositionAsVisited(territory);
                    findCurrentPosition(territory, "B");
                    break;
                default:
                    break;
            }
            setCurrentPosition(territory);
        }
        if (food < 10) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + food);
        printMatrix(territory);
    }

    private static void printMatrix(String[][] bakery) {
        for (String[] strings : bakery) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static boolean invalidPosition(String[][] bakery) {
        return row < 0 || row >= bakery.length || column < 0 || column >= bakery.length;
    }

    private static void setPositionAsVisited(String[][] bakery) {
        bakery[row][column] = ".";
    }

    private static void setCurrentPosition(String[][] bakery) {
        bakery[row][column] = "S";
    }

    private static void findCurrentPosition(String[][] territory, String symbol) {
        boolean areSet = false;
        for (int i = 0; i < territory.length; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                if (territory[i][j].equals(symbol)) {
                    row = i;
                    column = j;
                    areSet = true;
                    break;
                }
            }
            if (areSet) break;
        }
    }

    private static void movePosition(String command, String[][] bakery) {
        setPositionAsVisited(bakery);
        switch (command) {
            case "up":
                row = row - 1;
                break;
            case "down":
                row = row + 1;
                break;
            case "left":
                column = column - 1;
                break;
            case "right":
                column = column + 1;
                break;
        }
    }
}
