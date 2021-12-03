package dev.inca.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubmarineDriverTest {

    @Test
    void testExample_shouldReturn150() {
        SubmarineDriver subDriver = new SubmarineDriver();
        int position = subDriver.calcPosition("instructions_day2_example.txt");

        Assertions.assertEquals(150, position);
    }

    @Test
    void testPart1_shouldGiveRightAnswer() {
        SubmarineDriver subDriver = new SubmarineDriver();
        int position = subDriver.calcPosition("instructions_day2_part1.txt");

        System.out.printf("answer=%s", position);
    }

    @Test
    void testExamplePart2_shouldReturn900() {
        SubmarineDriver subDriver = new SubmarineDriver();
        int position = subDriver.calcPositionV2("instructions_day2_example.txt");

        Assertions.assertEquals(900, position);
    }

    @Test
    void testExamplePart2_shouldGiveRightAnswer() {
        SubmarineDriver subDriver = new SubmarineDriver();
        int position = subDriver.calcPositionV2("instructions_day2_part2.txt");

        System.out.printf("answer=%s", position);
    }

}
