import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver(readMeasurements(args[0]));
        System.out.println(solver.countIncreasingMeasurements());
        System.out.println(solver.countIncreasingWindows(3));
    }

    private static int[] readMeasurements(String filename) {
        try (Stream<String> lines = Files.lines(Path.of(filename), Charset.defaultCharset())) {
            return lines.mapToInt(Integer::parseInt).toArray();
        } catch (IOException ex) {
            System.err.println("Error occurred while reading file");
            ex.printStackTrace();
        }
        return new int[] {};
    }
}
