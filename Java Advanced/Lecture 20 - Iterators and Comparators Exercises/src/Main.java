import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String[] elements = new String[input.size()-1];
        if (input.size()>1){
            input.remove("Create");
            for (int i = 0; i < input.size(); i++) {
                elements[i] = input.get(i);
            }
        }
        ListyIterator listy = new ListyIterator(elements);
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            switch (command) {
                case "HasNext":
                    System.out.println(listy.hasNext());
                    break;
                case "Move":
                    System.out.println(listy.move());
                    break;
                case "Print":
                    listy.print();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
