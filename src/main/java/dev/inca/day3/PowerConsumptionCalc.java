package dev.inca.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PowerConsumptionCalc {

    private final DiagnosticReport report;
    private final String reportFile;

    public PowerConsumptionCalc(String diagnosticReportFile) {
        this.report = new FileDiagnosticReport();
        this.reportFile = diagnosticReportFile;
    }

    public int calculateOxygenAndCO2Ratings() {

        List<String> bytes = report.read(reportFile);

        if (bytes.isEmpty()) return 0;

        List<String> oxygenBytes = new ArrayList<>(bytes);

        int i = 0;
        int totalZeros = 0;
        int totalOnes= 0;
        while (i < oxygenBytes.get(0).length() && oxygenBytes.size() != 1) {

            totalOnes = 0;
            totalZeros = 0;

            for (String bite : oxygenBytes) {
                if (Character.getNumericValue(bite.charAt(i)) == 0) totalZeros++;
                else totalOnes++;
            }

            oxygenBytes = reduceList(i, totalOnes >= totalZeros ? "1" : "0", oxygenBytes);

            i++;
        }

        int oxygenDecimal = bytesToDecimal(oxygenBytes.get(0));


        List<String> co2Bytes = new ArrayList<>(bytes);
        i = 0;
        totalZeros = 0;
        totalOnes= 0;
        while (i < co2Bytes.get(0).length() && co2Bytes.size() != 1) {

            totalOnes = 0;
            totalZeros = 0;

            for (String bite : co2Bytes) {
                if (Character.getNumericValue(bite.charAt(i)) == 0) totalZeros++;
                else totalOnes++;
            }

            co2Bytes = reduceList(i, totalZeros <= totalOnes ? "0" : "1", co2Bytes);

            i++;
        }

        int co2Decimal = bytesToDecimal(co2Bytes.get(0));

        return oxygenDecimal * co2Decimal;
    }

    private List<String> reduceList(final int position, final String character, List<String> oxygenBytes) {
        return oxygenBytes
                .stream()
                .filter(s -> s.charAt(position) == character.charAt(0))
                .collect(Collectors.toList());
    }

    public int calculatePowerConsumption() {

        List<String> bytes = report.read(reportFile);

        if (bytes.isEmpty()) return 0;

        int[][] byteCounter = new int[bytes.get(0).length()][2];

        for (int i = 0; i < bytes.size(); i++) {
            String bite = bytes.get(i);
            for (int j = 0; j < bite.length(); j++) {
                if (Character.getNumericValue(bite.charAt(j)) == 0) byteCounter[j][0] += 1;
                if (Character.getNumericValue(bite.charAt(j)) == 1) byteCounter[j][1] += 1;
            }
        }

        String gammaByte = "";
        String epsilonByte = "";
        for (int i = 0; i < byteCounter.length; i++) {
            gammaByte = gammaByte.concat(byteCounter[i][0] > byteCounter[i][1] ? "0" : "1");
            epsilonByte = epsilonByte.concat(byteCounter[i][0] < byteCounter[i][1] ? "0" : "1");
        }

        int gammaDecimalValue = bytesToDecimal(gammaByte);
        int epsilonDecimalValue = bytesToDecimal(epsilonByte);

        return gammaDecimalValue * epsilonDecimalValue;
    }

    private int bytesToDecimal(final String bytes) {

        int decimalValue = 0;

        for (int i = 0; i < bytes.length(); i++) {
            if (Character.getNumericValue(bytes.charAt(i)) == 0) continue;
            decimalValue += Math.pow(2, bytes.length() - (i + 1));
        }

        return decimalValue;
    }
}
