package dev.inca.day1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileCoordinateReader implements CoordinateReader {

    @Override
    public List<Integer> readCoordinates(String fileName) {
        List<Integer> coordinates = new ArrayList<>();

        try {
            coordinates = Files.readAllLines(Paths.get("src", "test", "resources", fileName))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (Exception ex) {
            throw new RuntimeException(String.format("unable to find the file=%s", fileName), ex);
        }

        return coordinates;
    }
}
