package softuni.fundamentals.java;

public class test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Marto");
        sb.delete(0, 2);
        System.out.println(sb.toString());
    }
}
