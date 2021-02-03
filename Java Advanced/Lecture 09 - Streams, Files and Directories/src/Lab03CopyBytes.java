import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Lab03CopyBytes {
    public static void main(String[] args) {
        String input = "input.txt";
        String output = "out.txt";
        try {
            FileInputStream inputStream = new FileInputStream(input);
            FileOutputStream outputStream = new FileOutputStream(output);
            PrintWriter writer = new PrintWriter(outputStream);
            int currentByte = inputStream.read();
            while (currentByte>=0) {
                char forPrint = (char) currentByte;
                if (forPrint == 10 || forPrint == 32) {
                    writer.print(forPrint);
                } else {
                    writer.print(currentByte);
                }
                currentByte = inputStream.read();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
