package advent2018.day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part2 {
    private static final int MAX_FABRIC_SIZE = 1000;

    public static void main(String[] args) throws IOException, URISyntaxException {
        Path inputPath = Paths.get(ClassLoader.getSystemResource("day3.txt").toURI());

        Pattern pattern = Pattern.compile("#(?<id>\\d*) @ (?<left>\\d*),(?<top>\\d*): (?<width>\\d*)x(?<height>\\d*)");

        Cell[][] fabric = new Cell[MAX_FABRIC_SIZE][MAX_FABRIC_SIZE];

        List<Integer> candidateIds = new ArrayList<>();

        Files.lines(inputPath)
              .forEach(l -> {
                Matcher matcher = pattern.matcher(l);
                boolean anyMatches = matcher.matches();
                if (anyMatches) {
                    int id = Integer.parseInt(matcher.group("id"));
                    int x = Integer.parseInt(matcher.group("left"));
                    int y = Integer.parseInt(matcher.group("top"));
                    int width = Integer.parseInt(matcher.group("width"));
                    int height = Integer.parseInt(matcher.group("height"));
                    candidateIds.add(id);

                    for (int w = x; w < (x + width); w++) {
                        for (int h = y; h < (y + height); h++) {
                            if (fabric[w][h] == null) {
                                Cell cell = new Cell();
                                fabric[w][h] = cell;
                            } else {
                                //already exists and hence a clash
                                //remove both the ids from the candidate list
                                candidateIds.removeAll(fabric[w][h].ids);
                                candidateIds.remove((Integer)id);
                            }
                            fabric[w][h].ids.add(id) ;
                        }
                    }
                }
              });
//        printFabric(fabric);

        System.out.println("candidateIds = " + candidateIds);

    }

    private static class Cell {
        List<Integer> ids = new ArrayList<>();

        @Override
        public String toString() {
            return "Cell{" +
                  "ids=" + ids +
                  '}';
        }
    }

    private static void printFabric(Cell[][] fabric) {
        for (Cell[] cells : fabric) {
            for (Cell cell : cells) {
                System.out.print(cell == null ? "." : cell);
            }
            System.out.println();
        }
        System.out.println();
    }

}



