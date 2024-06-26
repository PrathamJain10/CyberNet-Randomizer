import java.io.*;
import java.nio.file.*;
import java.util.*;

public class hop {

    private static final String INPUT_FILE = "randomrule.txt";
    private static final String OUTPUT_FILE = "output.txt"; // File to store output
    private static final int HOP_VALUE = 4; // Fixed hop value for ascending order
    private static final int MAX_HOP_RANGE = 100; // Maximum hop range for ascending order

    public static void main(String[] args) {
        List<String> values = null;
        try {
            values = readValuesFromFile(INPUT_FILE);
        } catch (IOException e) {
            System.err.println("Error reading from input file: " + e.getMessage());
            return;
        }

        List<Integer> remainingIndexes = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            remainingIndexes.add(i);
        }

        int totalValues = values.size();
        Random random = new Random();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {

            Set<Integer> visitedIndexes = new HashSet<>();
            int index = getRandomStartingIndex(remainingIndexes, random, 1, 100); // Start from a random index between 1 and 100
            bufferedWriter.write("Index: " + index + ", Value: " + values.get(index) + System.lineSeparator());
            remainingIndexes.remove(Integer.valueOf(index));
            visitedIndexes.add(index);

            // Visit randomly from top to bottom with controlled randomness
            while (!remainingIndexes.isEmpty() && index < totalValues - 1) {
                int nextIndex = getNextControlledRandomAscendingIndex(index, remainingIndexes, random);
                if (nextIndex == -1) {
                    break; // No more valid ascending indexes
                }
                bufferedWriter.write("Index: " + nextIndex + ", Value: " + values.get(nextIndex) + System.lineSeparator());
                remainingIndexes.remove(Integer.valueOf(nextIndex));
                visitedIndexes.add(nextIndex);
                index = nextIndex;
            }

            // Visit remaining indexes from bottom to top, 4 hops at a time
            index = totalValues - 1; // Start from the last index
            while (!remainingIndexes.isEmpty()) {
                int count = 0;
                while (count < HOP_VALUE && index >= 0) {
                    index--;
                    count++;
                }
                while (index >= 0 && !remainingIndexes.contains(index)) {
                    index--;
                }
                if (index >= 0) {
                    bufferedWriter.write("Index: " + index + ", Value: " + values.get(index) + System.lineSeparator());
                    remainingIndexes.remove(Integer.valueOf(index));
                    visitedIndexes.add(index);
                }
                if (index < 0 && !remainingIndexes.isEmpty()) {
                    index = remainingIndexes.get(remainingIndexes.size() - 1); // Restart from the highest remaining index
                }
            }

        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }

        // Print final confirmation that all values have been visited
        if (remainingIndexes.isEmpty()) {
            System.out.println("All values have been visited. Remaining indexes: []");
        } else {
            System.out.println("Some indexes were not visited. Remaining indexes: " + remainingIndexes);
        }
    }

    private static List<String> readValuesFromFile(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename));
    }

    private static int getNextControlledRandomAscendingIndex(int currentIndex, List<Integer> remainingIndexes, Random random) {
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

    private static int getRandomStartingIndex(List<Integer> remainingIndexes, Random random, int minRange, int maxRange) {
        List<Integer> validIndexes = new ArrayList<>();
        for (Integer idx : remainingIndexes) {
            if (idx >= minRange && idx <= maxRange) {
                validIndexes.add(idx);
            }
        }
        return validIndexes.get(random.nextInt(validIndexes.size()));
    }
}
