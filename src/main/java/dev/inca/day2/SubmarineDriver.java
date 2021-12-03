package dev.inca.day2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubmarineDriver {

    private Coordinate coordinate;
    private List<Instruction> instructions;

    public SubmarineDriver() {
        this.coordinate = new Coordinate(0, 0, 0);
    }

    public int calcPosition(String instructionsFile) {

        instructions = readInstructions(instructionsFile);

        if (instructions.isEmpty()) return 0;

        for (Instruction instruction : instructions) {

            if (instruction.getDirection().equals("forward")) {
                coordinate.setHorizontal(coordinate.getHorizontal() + instruction.getUnit());
            }

            if (instruction.getDirection().equals("down")) {
                coordinate.setDepth(coordinate.getDepth() + instruction.getUnit());
            }

            if (instruction.getDirection().equals("up")) {
                coordinate.setDepth(coordinate.getDepth() - instruction.getUnit());
            }
        }

        return coordinate.getDepth() * coordinate.getHorizontal();
    }

    public int calcPositionV2(String instructionsFile) {

        instructions = readInstructions(instructionsFile);

        if (instructions.isEmpty()) return 0;

        for (Instruction instruction : instructions) {

            if (instruction.getDirection().equals("forward")) {
                coordinate.setHorizontal(coordinate.getHorizontal() + instruction.getUnit());
                coordinate.setDepth(coordinate.getDepth() + coordinate.getAim() * instruction.getUnit());
            }

            if (instruction.getDirection().equals("down")) {
                coordinate.setAim(coordinate.getAim() + instruction.getUnit());
            }

            if (instruction.getDirection().equals("up")) {
                coordinate.setAim(coordinate.getAim() - instruction.getUnit());
            }
        }

        return coordinate.getDepth() * coordinate.getHorizontal();
    }

    private List<Instruction> readInstructions(String instructionsFile) {

        List<Instruction> instructions = new ArrayList<>();

        try {
            instructions = Files.readAllLines(Paths.get("src", "test", "resources", instructionsFile))
                    .stream()
                    .map(Instruction::convert)
                    .collect(Collectors.toList());
        }
        catch (Exception ex) {
            throw new RuntimeException("unable to read instructions", ex);
        }

        return instructions;
    }


}
