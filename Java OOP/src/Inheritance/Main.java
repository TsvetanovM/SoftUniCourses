package Inheritance;

public class Main {
    public static void main(String[] args) {
        RandomArrayList list = new RandomArrayList();
        list.add(12);
        list.add(13);
        list.add(42);
        list.add(68);
        list.add(73);
        list.add(111);
        list.add(7);

        System.out.println(list.getRandomElement());
    }
}
