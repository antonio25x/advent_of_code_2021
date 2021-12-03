package dev.inca.day2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Instruction {
    private String direction;
    private int unit;

    public static Instruction convert(String line) {
        String[] tokens = line.split(" ");
        String direction = tokens[0];
        int unit = Integer.parseInt(tokens[1]);
        return new Instruction(direction, unit);
    }
}
