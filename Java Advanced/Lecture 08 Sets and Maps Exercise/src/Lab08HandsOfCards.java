import java.util.*;

public class Lab08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> allPlayers = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(":");
            String name = tokens[0];
            allPlayers.putIfAbsent(name, new HashSet<>());
            String[] cardsToAdd = tokens[1].trim().split(",\\s+");
            for (String card : cardsToAdd) {
                allPlayers.get(name).add(card);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> player : allPlayers.entrySet()) {
            int totalValue = 0;
            while (player.getValue().size()>0){
                StringBuilder current = new StringBuilder(player.getValue().iterator().next());
                player.getValue().remove(current.toString());
                String type = current.substring(current.length() - 1);
                current.deleteCharAt(current.length() - 1);
                String power = current.toString();
                int typeValue = 0;
                switch (type) {
                    case "S":
                        typeValue = 4;
                        break;
                    case "H":
                        typeValue = 3;
                        break;
                    case "D":
                        typeValue = 2;
                        break;
                    case "C":
                        typeValue = 1;
                        break;
                }
                int powerValue = 0;
                switch (power) {
                    case "J":
                        powerValue = 11;
                        break;
                    case "Q":
                        powerValue = 12;
                        break;
                    case "K":
                        powerValue = 13;
                        break;
                    case "A":
                        powerValue = 14;
                        break;
                    default:
                        powerValue = Integer.parseInt(power);
                        break;
                }
                totalValue += powerValue*typeValue;
            }
            System.out.println(player.getKey() + ": " + totalValue);
        }
    }
}
