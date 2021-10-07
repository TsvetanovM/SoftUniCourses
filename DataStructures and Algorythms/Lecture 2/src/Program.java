import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Date start = new Date();
        executeAlgorithm();
        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());
    }

    private static void executeAlgorithm() {
        long n = 1000000L * 1000L * 10L;

        for (long i = 0; i < n; i++) {

        }
    }
}
