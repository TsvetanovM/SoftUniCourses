import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String validator = "^@#+[A-Z][A-Za-z\\d]{4,}[A-Z]@#+$";
        Pattern pattern = Pattern.compile(validator);

        for (int i = 0; i < n; i++) {
            String barcode = scan.nextLine();
            Matcher match = pattern.matcher(barcode);
            if (!match.find()){
                System.out.println("Invalid barcode");
                continue;
            }
            StringBuilder productGroup = new StringBuilder();
            for (int j = 0; j < barcode.length(); j++){
                char current = barcode.charAt(j);
                if (Character.isDigit(current)){
                    productGroup.append(current);
                }
            }
            if (productGroup.length()==0){
                productGroup.append("00");
            }

            System.out.println("Product group: " + productGroup);
        }
    }
}
