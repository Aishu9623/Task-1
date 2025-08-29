import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Task1_FileHandling {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("sample.txt");

        // Subtask 1: Write, Append, Read
        Files.writeString(path, "Hello, this is a file handling demo!\n");
        Files.writeString(path, "Appending a new line.\n", StandardOpenOption.APPEND);
        System.out.println("Reading file content:");
        Files.lines(path).forEach(System.out::println);

        // Subtask 2: Modify (replace, insert, delete)
        String content = Files.readString(path).replace("demo", "example");
        Files.writeString(path, content, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("After Replace:");
        Files.lines(path).forEach(System.out::println);

        // Insert at top
        List<String> lines = Files.readAllLines(path);
        lines.add(0, "Inserted at line 1");
        Files.write(path, lines);
        System.out.println("After Insert:");
        Files.lines(path).forEach(System.out::println);

        // Delete 2nd line if exists
        lines = Files.readAllLines(path);
        if (lines.size() > 1) {
            lines.remove(1);
            Files.write(path, lines);
        }
        System.out.println("After Delete:");
        Files.lines(path).forEach(System.out::println);
    }
}
