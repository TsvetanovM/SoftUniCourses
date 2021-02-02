import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> logTrace = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].replace("IP=", "");
            String user = tokens[2].replace("user=", "");
            logTrace.putIfAbsent(user, new LinkedHashMap<>());
            logTrace.get(user).putIfAbsent(ip, 0);
            logTrace.get(user).put(ip, logTrace.get(user).get(ip) + 1);
            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : logTrace.entrySet()) {
            System.out.println(entry.getKey() + ":");
            int counter = entry.getValue().size()-1;
            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                if (counter==0) {
                    System.out.println(integerEntry.getKey() + " => " + integerEntry.getValue() + ".");
                } else {
                    System.out.print(integerEntry.getKey() + " => " + integerEntry.getValue() + ", ");
                }
                counter--;
            }
        }

//        logTrace.forEach((k, v) -> {
//            System.out.println(k + ":");
//            v.forEach((kk, vv) -> {
//                System.out.print(kk + " => " + vv + ", ");
//                System.out.println(kk + " => " + vv + ".");
//            });
//        });
    }
}
