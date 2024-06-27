import java.io.IOException;
import java.util.List;

public class Main {

    private static final String INPUT_FILE = "randomrule.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) {
        List<String> values = null;
        try {
            values = FileReaderUtil.readValuesFromFile(INPUT_FILE);
        } catch (IOException e) {
            System.err.println("Error reading from input file: " + e.getMessage());
            return;
        }

        HopProcessor.processValues(values, OUTPUT_FILE);
    }
}
