public record Solver(int[] measurements) {

    public int countIncreasingMeasurements() {
        return countIncreasingWindows(1);
    }

    public int countIncreasingWindows(int windowSize) {
        if (measurements.length <= windowSize) {
            return 0;
        }

        int count = 0;
        for (int i = windowSize; i < measurements.length; i++) {
            if (isIncreasing(i, windowSize)) {
                count++;
            }
        }

        return count;
    }

    private boolean isIncreasing(int index, int window) {
        int previousSum = 0;
        int currentSum = 0;
        for (int i = index; i > index - window; i--) {
            previousSum += measurements[i - 1];
            currentSum += measurements[i];
        }
        return currentSum > previousSum;
    }
}
