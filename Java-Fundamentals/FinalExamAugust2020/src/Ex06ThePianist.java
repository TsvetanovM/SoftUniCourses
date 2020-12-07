import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex06ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, String[]> pieces = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] pieceInfo = scan.nextLine().split("\\|");
            String[] currentPiece = new String[2];
            currentPiece[0] = pieceInfo[1];
            currentPiece[1] = pieceInfo[2];
            pieces.put(pieceInfo[0], currentPiece);
        }

        String input = scan.nextLine();
        while (!input.equals("Stop")) {
            String[] instructions = input.split("\\|");
            String command = instructions[0];
            String pieceName = instructions[1];
            switch (command) {
                case "Add":
                    if (pieces.containsKey(pieceName)){
                        System.out.println(pieceName + " is already in the collection!");
                    }
                    else {
                        String[] pieceInfo = new String[2];
                        pieceInfo[0] = instructions[2];
                        pieceInfo[1] = instructions[3];
                        pieces.put(pieceName, pieceInfo);
                        System.out.printf("%s by %s in %s added to the collection!%n", pieceName, pieceInfo[0], pieceInfo[1]);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(pieceName)){
                        pieces.remove(pieceName);
                        System.out.println("Successfully removed " + pieceName + "!");
                    }
                    else {
                        System.out.println("Invalid operation! " + pieceName + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    if (pieces.containsKey(pieceName)){
                        String[] newKey = new String[2];
                        newKey[0] = pieces.get(pieceName)[0];
                        newKey[1] = instructions[2];
                        pieces.put(pieceName, newKey);
                        System.out.println("Changed the key of " + pieceName + " to " + pieces.get(pieceName)[1] + "!");
                    }
                    else {
                        System.out.println("Invalid operation! " + pieceName + " does not exist in the collection.");
                    }
                    break;
            }
            input = scan.nextLine();
        }
        pieces.entrySet().stream()
                .forEach(p -> System.out.printf("%s -> Composer: %s, Key: %s%n", p.getKey(), p.getValue()[0], p.getValue()[1]));
    }
}
