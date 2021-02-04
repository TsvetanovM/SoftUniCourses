import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Lab05WriteEveryThirdLine {
    public static void main(String[] args) {
        try {
            List<String> strings = Files.readAllLines(Path.of("input.txt"));

            List<String> lines = new ArrayList<>();

            for (int i = 2; i < strings.size(); i += 3) {
                lines.add(strings.get(i));
            }

            Files.write(Path.of("out.txt"), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
