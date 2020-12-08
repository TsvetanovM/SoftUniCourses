import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().split(",\\s+");

        for (String ticket : tickets) {
            ticket = ticket.trim();
            String validityCheck = "^.{20}$";
            Pattern pattern = Pattern.compile(validityCheck);
            Matcher matcher = pattern.matcher(ticket);

            if (!matcher.find()) {
                System.out.println("invalid ticket");
                continue;
            }

            String firstHalf = ticket.substring(0, 10);
            String secondHalf = ticket.substring(10);
            String winnerCheck = "[@#$^]{6,}";
            Pattern pattern1 = Pattern.compile(winnerCheck);
            Matcher matcher1 = pattern1.matcher(firstHalf);

            if (!matcher1.find()) {
                System.out.println("ticket \"" + ticket + "\" - no match");
                continue;
            }

            String winningCombo = matcher1.group();

            Pattern pattern2 = Pattern.compile(winningCombo);
            Matcher matcher2 = pattern2.matcher(secondHalf);

            if (!matcher2.find()) {
                System.out.println("ticket \"" + ticket + "\" - no match");
                continue;
            }

            if (winningCombo.length() == 10) {
                System.out.println("ticket \"" + ticket + "\" - 10" + winningCombo.charAt(2) + " Jackpot!");
                continue;
            }

            System.out.println("ticket \"" + ticket + "\" - " + winningCombo.length() + winningCombo.charAt(4));
        }
    }
}
