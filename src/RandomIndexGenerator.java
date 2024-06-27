import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomIndexGenerator {

    private static final int MAX_HOP_RANGE = 100; // Maximum hop range for ascending order

    public static int getNextControlledRandomAscendingIndex(int currentIndex, List<Integer> remainingIndexes, Random random) {
        List<Integer> validIndexes = new ArrayList<>();
        for (Integer idx : remainingIndexes) {
            if (idx > currentIndex && idx <= currentIndex + MAX_HOP_RANGE) {
                validIndexes.add(idx);
            }
        }
        if (validIndexes.isEmpty()) {
            return -1; // No valid indexes found
        }
        return validIndexes.get(random.nextInt(validIndexes.size()));
    }

    public static int getRandomStartingIndex(List<Integer> remainingIndexes, Random random, int minRange, int maxRange) {
        List<Integer> validIndexes = new ArrayList<>();
        for (Integer idx : remainingIndexes) {
            if (idx >= minRange && idx <= maxRange) {
                validIndexes.add(idx);
            }
        }
        return validIndexes.get(random.nextInt(validIndexes.size()));
    }
}
