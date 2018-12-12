package advent2018.day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day3Part1 {
    private static final int MAX_FABRIC_SIZE = 1000;

    public static void main(String[] args) throws IOException, URISyntaxException {
        Path inputPath = Paths.get(ClassLoader.getSystemResource("day3.txt").toURI());

        Pattern pattern = Pattern.compile("#(?<id>\\d*) @ (?<left>\\d*),(?<top>\\d*): (?<width>\\d*)x(?<height>\\d*)");

        String[][] fabric = new String[MAX_FABRIC_SIZE][MAX_FABRIC_SIZE];

        Files.lines(inputPath)
              .forEach(l -> {
                Matcher matcher = pattern.matcher(l);
                boolean anyMatches = matcher.matches();
                if (anyMatches) {
                    System.out.println("matcher = " + matcher.group(0));
                    int x = Integer.parseInt(matcher.group("left"));
                    int y = Integer.parseInt(matcher.group("top"));
                    int width = Integer.parseInt(matcher.group("width"));
                    int height = Integer.parseInt(matcher.group("height"));

                    for (int w = x; w < (x + width); w++) {
                        for (int h = y; h < (y + height); h++) {
                            if (fabric[w][h] == null) {
                                fabric[w][h] = "1";
                            } else {
                                fabric[w][h] = "X";
                            }
                        }
                    }
                }
              });
        printFabric(fabric);

        long clashingClaims = 0;
        for (String[] rows : fabric) {
            for (String cell : rows) {
                if ("X".equals(cell)) {
                    clashingClaims++;
                }
            }
        }

        System.out.println("clashingClaims = " + clashingClaims);

    }

    private static void printFabric(String[][] fabric) {
        for (String[] strings : fabric) {
            for (String string : strings) {
                System.out.print(string == null ? "." : string);
            }
            System.out.println();
        }
        System.out.println();
    }

}



