import java.io.File;

public class Lab07ListFiles {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\tsvet\\Desktop\\Lecture09\\Files-and-Streams");

        File[] allFiles = file.listFiles();

        for (File f : allFiles) {
            if (!f.isDirectory()){
                System.out.println(f.getName() + ": [" + f.length() + "]");
            }
        }
    }
}
