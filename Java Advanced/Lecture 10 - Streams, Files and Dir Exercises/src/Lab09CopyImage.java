import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab09CopyImage {
    private static final String inputImage = "horseshoe bend.png";
    private static final String outputImage = "Copied picture.png";
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(inputImage)) {
            FileOutputStream fos = new FileOutputStream(outputImage);

            int oneByte = fis.read();
            
            while (oneByte != -1) {
                fos.write(oneByte);
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
