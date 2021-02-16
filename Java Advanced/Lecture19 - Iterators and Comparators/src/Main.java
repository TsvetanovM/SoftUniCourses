

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        if (bookOne.compareTo(bookTwo) > 0) {
            System.out.printf("%s is before %s%n", bookOne, bookTwo);
        } else if (bookOne.compareTo(bookTwo) < 0) {
            System.out.printf("%s is before %s%n", bookTwo, bookOne);
        } else {
            System.out.println("Books are equal");
        }
//        Library library = new Library(new Book("Lord of the Rings", 1938, "Tolkien"),
//                new Book("Way of Kings", 2010, "Brandon Sanderson"),
//                new Book("Words of Radiance", 2013));
//
//        for (Book book : library) {
//            System.out.println(book);
//        }
    }
}
