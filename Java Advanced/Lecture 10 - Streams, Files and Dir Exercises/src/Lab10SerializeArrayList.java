import java.io.*;
import java.util.List;

public class Lab10SerializeArrayList {
    private static final String PATH = "list.ser";

    public static void main(String[] args) {
        List<Double> list = List.of(4.5, 3.3, 6.9, 42.013);
        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream(PATH);
             ObjectInputStream oos = new ObjectInputStream(fileInputStream)) {
            List<Double> result = (List<Double>) oos.readObject();
            result.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
