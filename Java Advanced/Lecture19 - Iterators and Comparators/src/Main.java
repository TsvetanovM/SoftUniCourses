
public class Main {
    public static void main(String[] args) {
        Library library = new Library(new Book("Lord of the Rings", 1938, "Tolkien"),
                new Book("Way of Kings", 2010, "Brandon Sanderson"),
                new Book("Words of Radiance", 2013));

        for (Book book : library) {
            System.out.println(book);
        }
    }
}
