import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Lab12CreateZipArchive {
    private static final String FIRST_READ = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
    private static final String SECOND_READ = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
    private static final String THIRD_READ = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
    private static final String OUTPUT_ZIP = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

    public static void main(String[] args) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(OUTPUT_ZIP))){
            addToZip(FIRST_READ, zos);
            addToZip(SECOND_READ, zos);
            addToZip(THIRD_READ, zos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addToZip(String path, ZipOutputStream zos) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        String fileName = file.getName();

        ZipEntry zipEntry = new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }
    }
}
