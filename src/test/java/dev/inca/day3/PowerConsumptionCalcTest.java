package dev.inca.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PowerConsumptionCalcTest {

    @Test
    void testExample_shouldReturn198() {
        PowerConsumptionCalc powerConsumptionCalc = new PowerConsumptionCalc("diagnostic_report_day3_example.txt");

        int powerConsumption = powerConsumptionCalc.calculatePowerConsumption();

        Assertions.assertEquals(198, powerConsumption);
    }

    @Test
    void testPart1_shouldReturnRightAnswer() {
        PowerConsumptionCalc powerConsumptionCalc = new PowerConsumptionCalc("diagnostic_report_day3_part1.txt");

        int powerConsumption = powerConsumptionCalc.calculatePowerConsumption();

        System.out.printf("answer=%s", powerConsumption);
    }

    @Test
    void testExample_shouldReturn230() {
        PowerConsumptionCalc powerConsumptionCalc = new PowerConsumptionCalc("diagnostic_report_day3_example.txt");

        int oxygenAndCO2Ratings = powerConsumptionCalc.calculateOxygenAndCO2Ratings();

        Assertions.assertEquals(230, oxygenAndCO2Ratings);
    }

    @Test
    void testPart2_shouldReturnRightAnswer() {
        PowerConsumptionCalc powerConsumptionCalc = new PowerConsumptionCalc("diagnostic_report_day3_part2.txt");

        int oxygenAndCO2Ratings = powerConsumptionCalc.calculateOxygenAndCO2Ratings();

        System.out.printf("answer=%s", oxygenAndCO2Ratings);
    }
}
