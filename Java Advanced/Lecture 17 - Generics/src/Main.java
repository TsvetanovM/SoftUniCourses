public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();

        jar.add(22);
        jar.add(25);

        jar.remove(25);
    }
}
