package main.advent2018.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1Part2 {

    public static void main(String[] args) throws IOException, URISyntaxException {

        Set<Long> freqs = new HashSet<>();
        freqs.add(0L);

        var ref = new Object() {
            long freq = 0;
        };

        Path inputPath = Paths.get(ClassLoader.getSystemResource("day1.txt").toURI());

        boolean enough = false;
        int n = 0;
        while (!enough) {
            Files.lines(inputPath)
                  .forEach(l -> {
                      ref.freq += Long.parseLong(l);
                      boolean added = freqs.add(ref.freq);
                      System.out.println(
                            "l = " + l + ", ref.freq = " + ref.freq + ",  added = " + added);
                      if (!added) {
                          System.out.println("Frequency that repeats = " + ref.freq);
                          System.exit(0);
                      }
                  });

            if (n > 1000) {
                enough = true;
            }
            n++;
        }
    }

}



