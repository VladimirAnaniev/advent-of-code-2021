import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Diagnostics diagnostics = new Diagnostics(readBitSequences(args[0]));

        String gamma = diagnostics.getGamma();
        String epsilon = diagnostics.getEpsilon();

        String oxygenRating = diagnostics.getOxygenRating();
        String co2Rating = diagnostics.getCo2Rating();

        System.out.println(toDecimal(gamma) * toDecimal(epsilon));
        System.out.println(toDecimal(oxygenRating) * toDecimal(co2Rating));
    }

    private static String[] readBitSequences(String filename) {
        try (Stream<String> lines = Files.lines(Path.of(filename), Charset.defaultCharset())) {
            return lines.toArray(String[]::new);
        } catch (IOException ex) {
            System.err.println("Error occurred while reading file");
            ex.printStackTrace();
        }
        return new String[] {};
    }

    private static int toDecimal(String binary) {
        int n = 0;
        for(int i = 0; i < binary.length(); i++) {
            if (binary.charAt(binary.length() - 1 - i) == '1') {
                n += 1 << i;
            }
        }
        return n;
    }
}
