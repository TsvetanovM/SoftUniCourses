import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Lab08GetFolderSize {
    private static final String DIR_PATH = ("C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

    public static void main(String[] args) {

        try (PrintWriter writer = new PrintWriter("output.txt")) {

            File file = new File(DIR_PATH);

            File[] allFiles = file.listFiles();

            int length = 0;

            if (allFiles != null) {

                for (File f : allFiles) {
                    length += f.length();
                }
            }
            writer.println("Folder size: " + length);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("Folder size: " + length);
    }
}
