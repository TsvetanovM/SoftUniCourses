import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab02WriteToFile {
    public static void main(String[] args) {

        try (FileInputStream inputStream = new FileInputStream("input.txt")) {
            List<Character> punctuation = new ArrayList<>(Arrays.asList( ',', '.', '!', '?'));
            FileOutputStream outputStream = new FileOutputStream("out.txt");
            int oneByte = inputStream.read();
            while (oneByte>=0) {
                if (!punctuation.contains((char) oneByte)) {
                    outputStream.write(oneByte);
                }
                oneByte = inputStream.read();
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
