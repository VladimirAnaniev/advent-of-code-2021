import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] steps = readSteps(args[0]);
        List<Position> positions = Arrays.asList(new Part1Position(), new Part2Position());

        Arrays.stream(steps).forEach(step -> {
            String[] parts =step.split(" ");
            int value = Integer.parseInt(parts[1]);
            switch (parts[0]) {
                case "forward" -> positions.forEach(position -> position.forward(value));
                case "down" -> positions.forEach(position -> position.down(value));
                case "up" -> positions.forEach(position -> position.up(value));
            }
        });

        positions.forEach(position -> System.out.println(position.getPosition()));
    }

    private static String[] readSteps(String filename) {
        try (Stream<String> lines = Files.lines(Path.of(filename), Charset.defaultCharset())) {
            return lines.toArray(String[]::new);
        } catch (IOException ex) {
            System.err.println("Error occurred while reading file");
            ex.printStackTrace();
        }
        return new String[] {};
    }
}
