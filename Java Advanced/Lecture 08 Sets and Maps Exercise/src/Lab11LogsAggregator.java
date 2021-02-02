import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab11LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> logsTrack = new TreeMap<>();

        while (n-->0) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String user = inputData[1];
            String IP = inputData[0];
            Integer duration = Integer.parseInt(inputData[2]);
            logsTrack.putIfAbsent(user, new TreeMap<>());
            logsTrack.get(user).putIfAbsent(IP, 0);
            logsTrack.get(user).put(IP, logsTrack.get(user).get(IP) + duration);
        }

        logsTrack.forEach((k,v) -> {
            System.out.print(k + ": " + v.values().stream().mapToInt(I -> I).sum() + " ");
            System.out.println(Arrays.toString(v.keySet().toArray()));
        });
    }
}
