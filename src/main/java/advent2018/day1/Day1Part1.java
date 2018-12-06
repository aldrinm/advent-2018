package advent2018.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day1Part1 {

    public static void main(String[] args) throws IOException, URISyntaxException {

        final long[] freq = {0};

        Path inputPath = Paths.get(ClassLoader.getSystemResource("day1.txt").toURI());
        Files.lines(inputPath)
              .forEach(l -> freq[0] += Long.parseLong(l));

        System.out.println("ref.freq = " + freq[0]);
    }


}



