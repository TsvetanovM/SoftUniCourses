import java.util.Scanner;

public class Problem02_Selling {
    private static final int MONEY_NEEDED = 50;
    private static int row = 0;
    private static int column = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] bakery = new String[n][n];
        for (int i = 0; i < bakery.length; i++) {
            bakery[i] = scanner.nextLine().split("");
        }
        int collectedMoney = 0;
        findCurrentPosition(bakery, "S");
        while (collectedMoney < MONEY_NEEDED) {
            String command = scanner.nextLine();
            movePosition(command, bakery);
            if (invalidPosition(bakery)) {
                break;
            }
            String positionValue = bakery[row][column];
            switch (positionValue) {
                case "-":
                    break;
                case "O":
                    setPositionAsEmpty(bakery);
                    findCurrentPosition(bakery, "O");
                    break;
                default:
                    int value = Integer.parseInt(bakery[row][column]);
                    collectedMoney += value;
            }
            setCurrentPosition(bakery);
        }
        if (collectedMoney<MONEY_NEEDED) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + collectedMoney);
        printMatrix(bakery);
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

    private static void setPositionAsEmpty(String[][] bakery) {
        bakery[row][column] = "-";
    }

    private static void setCurrentPosition(String[][] bakery) {
        bakery[row][column] = "S";
    }

    private static void findCurrentPosition(String[][] bakery, String symbol) {
        boolean areSet = false;
        for (int i = 0; i < bakery.length; i++) {
            for (int j = 0; j < bakery[i].length; j++) {
                if (bakery[i][j].equals(symbol)) {
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
        setPositionAsEmpty(bakery);
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
