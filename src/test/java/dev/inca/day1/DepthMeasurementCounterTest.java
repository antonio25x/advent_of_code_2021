package dev.inca.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DepthMeasurementCounterTest {

    @Test
    void testExampleCoordinate_shouldReturn7() {
        DepthMeasurementCounter keyFinder = new DepthMeasurementCounter("coordinates_example.txt");

        int totalDepthIncrements = keyFinder.countDepthIncrementsBy(1);

        Assertions.assertEquals(7, totalDepthIncrements);

    }

    @Test
    void testDay_1() {
        DepthMeasurementCounter keyFinder = new DepthMeasurementCounter("coordinates_day1_part1.txt");

        int totalDepthIncrements = keyFinder.countDepthIncrementsBy(1);

        System.out.printf("answer=%d", totalDepthIncrements);

    }

    @Test
    void testExampleCoordinatePart2_shouldReturn5() {

        DepthMeasurementCounter keyFinder = new DepthMeasurementCounter("coordinates_example.txt");

        int totalDepthIncrements = keyFinder.countDepthIncrementsBy(3);

        Assertions.assertEquals(5, totalDepthIncrements);
    }

    @Test
    void testDay_1_part2() {
        DepthMeasurementCounter keyFinder = new DepthMeasurementCounter("coordinates_day2_part2.txt");

        int totalDepthIncrements = keyFinder.countDepthIncrementsBy(3);

        System.out.printf("answer=%d", totalDepthIncrements);

    }

}
