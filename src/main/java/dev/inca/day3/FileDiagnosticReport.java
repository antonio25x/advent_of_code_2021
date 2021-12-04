package dev.inca.day3;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileDiagnosticReport implements DiagnosticReport {

    @Override
    public List<String> read(String fileName) {

        List<String> bytes = new ArrayList<>();

        try {
            bytes = Files.readAllLines(Paths.get("src", "test", "resources", fileName));
        } catch (Exception ex) {
            throw new RuntimeException("unable to read file:" + fileName, ex);
        }

        return bytes;
    }
}
