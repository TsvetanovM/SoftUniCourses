import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, String> contests = new HashMap<>();

        while (!input.equals("end of contests")) {
            String[] contestInfo = input.split(":");
            contests.put(contestInfo[0], contestInfo[1]);
            input = scan.nextLine();
        }

        input = scan.nextLine();
        Map<String, User> allUsers = new TreeMap<>();
        while (!input.equals("end of submissions")){
            String[] userInfo = input.split("=>");
            if (!contests.containsKey(userInfo[0])){
                input = scan.nextLine();
                continue;
            }
            if (!contests.get(userInfo[0]).equals(userInfo[1])){
                input = scan.nextLine();
                continue;
            }
            allUsers.putIfAbsent(userInfo[2], new User(userInfo[0], userInfo[3]));
            allUsers.get(userInfo[2]).addContest(userInfo[0], userInfo[3]);
            input = scan.nextLine();
        }

        String bestUser = "";
        int maxPoints = 0;
        for (Map.Entry<String, User> entry : allUsers.entrySet()) {
            entry.getValue().setTotalPoints();
            if (entry.getValue().getTotalPoints()>maxPoints) {
                maxPoints = entry.getValue().getTotalPoints();
                bestUser = entry.getKey();
            }
        }

        System.out.println("Best candidate is " + bestUser + " with total " + maxPoints + " points.");
        System.out.println("Ranking:");

        allUsers.entrySet().stream()
                .forEach(u -> {
                    System.out.println(u.getKey());
                    u.getValue().getContestPerformance().entrySet().stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(c -> System.out.printf("#  %s -> %s%n", c.getKey(), c.getValue()));
                });
    }

    static class User {
        Map<String, String> contestPerformance = new LinkedHashMap<>();
        int totalPoints = 0;

        User(String contest, String points) {
            contestPerformance.put(contest, points);
        }


        public Map<String, String> getContestPerformance() {
            return contestPerformance;
        }

        public void addContest(String contest, String points) {
            if (contestPerformance.containsKey(contest)) {
                if (contestPerformance.get(contest).compareTo(points)<0) {
                    contestPerformance.put(contest, points);
                }
            }
            else {
                contestPerformance.put(contest, points);
            }
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints() {
            totalPoints = contestPerformance.values().stream()
                    .mapToInt(Integer::parseInt).sum();
        }
    }
}
