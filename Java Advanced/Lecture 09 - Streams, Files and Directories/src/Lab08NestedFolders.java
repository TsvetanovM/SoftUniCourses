import java.io.File;

public class Lab08NestedFolders {
    public static int folderCount = 1;

    public static void main(String[] args) {
        String path = "C:\\Users\\tsvet\\Desktop\\Lecture09\\Files-and-Streams";

        File file = new File(path);

        isDirectory(file);

        System.out.println(folderCount + " folders");
    }

    private static void isDirectory(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                folderCount++;
                System.out.println(f.getName());
                isDirectory(f);
            }
        }


    }
}
