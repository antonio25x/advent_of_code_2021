package dev.inca.day1;

import java.util.List;

public class DepthMeasurementCounter {

    private final List<Integer> depthCoords;
    private final CoordinateReader coordsReader;

    public DepthMeasurementCounter(List<Integer> coordinates) {
        this.depthCoords = coordinates;
        this.coordsReader = null;
    }

    public DepthMeasurementCounter(String location) {
        this.coordsReader = new FileCoordinateReader();
        this.depthCoords = this.coordsReader.readCoordinates(location);
    }

    public int countDepthIncrementsBy(final int slidingWindow) {

        if (depthCoords.isEmpty()) return 0;
        if (depthCoords.size() < slidingWindow) return 0;

        int totalDepthIncrements = 0;
        int previousSlidingWindowTotal = 0;

        for (int i = 0; i < depthCoords.size(); i++) {

            if (notEnoughCoordsForSlidingWindow(i, slidingWindow)) break;

            int currentSlidingWindowTotal = calculateCurrentSlidingWindowTotal(i, slidingWindow);

            if (isCurrentDepthBigger(previousSlidingWindowTotal, currentSlidingWindowTotal)) {
                totalDepthIncrements++;
            }

            previousSlidingWindowTotal = currentSlidingWindowTotal;
        }

        return totalDepthIncrements;
    }

    private boolean isCurrentDepthBigger(int totalPreviousSlidingWindow, int tempSlidingWindow) {
        return tempSlidingWindow > totalPreviousSlidingWindow
                && totalPreviousSlidingWindow != 0;
    }

    private int calculateCurrentSlidingWindowTotal(int i, int slidingWindow) {
        int tempSlidingWindow = 0;
        for (int s = slidingWindow - 1; s >= 0; s--) {
            tempSlidingWindow += depthCoords.get(i + s);
        }
        return tempSlidingWindow;
    }

    private boolean notEnoughCoordsForSlidingWindow(int currentElement, int slidingWindow) {
        return currentElement == depthCoords.size() - (slidingWindow - 1);
    }



    /*
 I started with these two methods, but then I refactored them into the method above
    public int countDepthIncrements() {

        if (depthCoords.isEmpty() || depthCoords.size() == 1) return 0;

        int totalDepthIncrements = 0;

        for (int i = 0; i < depthCoords.size(); i++) {
            if (i == 0) continue;
            if (depthCoords.get(i) > depthCoords.get(i - 1)) totalDepthIncrements++;
        }

        return totalDepthIncrements;
    }
    public int countDepthIncrementsV2() {

        if (depthCoords.isEmpty() || depthCoords.size() < 3) return 0;

        int totalDepthIncrements = 0;

        int windowCount = 0;

        for (int i = 0; i < depthCoords.size(); i++) {

            if (i == depthCoords.size() - 2) break;

            if (depthCoords.get(i) + depthCoords.get(i + 1) + depthCoords.get(i + 2) > windowCount
                && windowCount != 0) {
                totalDepthIncrements++;
            }

            windowCount = depthCoords.get(i) + depthCoords.get(i + 1) + depthCoords.get(i + 2);
        }

        return totalDepthIncrements;
    }
*/

}
