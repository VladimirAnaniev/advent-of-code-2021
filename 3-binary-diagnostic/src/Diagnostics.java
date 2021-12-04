import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Diagnostics {

    private final String[] records;
    private final Map<Integer, Character> mostCommonBit = new HashMap<>();

    public Diagnostics(String[] records) {
        this.records = records;
    }

    public String getGamma() {
        StringBuilder gamma = new StringBuilder();
        for (int i = 0; i < getSequenceLength(); i++) {
            gamma.append(getMostCommonBitAtIndex(i));
        }
        return gamma.toString();
    }

    public String getEpsilon() {
        StringBuilder epsilon = new StringBuilder();
        for (int i = 0; i < getSequenceLength(); i++) {
            epsilon.append(getLeastCommonBitAtIndex(i));
        }
        return epsilon.toString();
    }

    public String getOxygenRating() {
        Diagnostics diagnostics = this;
        int index = 0;
        while(diagnostics.records.length > 1) {
            char mostCommon = diagnostics.getMostCommonBitAtIndex(index);
            diagnostics = diagnostics.filterRecordsWithBitAtIndex(index, mostCommon);
            index++;
        }
        return diagnostics.records[0];
    }

    public String getCo2Rating() {
        Diagnostics diagnostics = this;
        int index = 0;
        while(diagnostics.records.length > 1) {
            char leastCommon = diagnostics.getLeastCommonBitAtIndex(index);
            diagnostics = diagnostics.filterRecordsWithBitAtIndex(index, leastCommon);
            index++;
        }
        return diagnostics.records[0];
    }

    private int getSequenceLength() {
        return records != null && records.length > 0 ? records[0].length() : 0;
    }

    private char getMostCommonBitAtIndex(int i) {
        if (!mostCommonBit.containsKey(i)) {
            long zerosCount = Arrays.stream(records).map(a -> a.charAt(i)).filter(c -> c == '0').count();
            mostCommonBit.put(i, zerosCount > (records.length / 2) ? '0' : '1');
        }

        return mostCommonBit.get(i);
    }

    private char getLeastCommonBitAtIndex(int i) {
        return getMostCommonBitAtIndex(i) == '0' ? '1' : '0';
    }

    private Diagnostics filterRecordsWithBitAtIndex(int i, char c) {
        return new Diagnostics(Arrays.stream(records).filter(x -> x.charAt(i) == c).toArray(String[]::new));
    }
}
