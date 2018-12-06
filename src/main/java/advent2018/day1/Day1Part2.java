package advent2018.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Day1Part2 {

    public static void main(String[] args) throws IOException, URISyntaxException {

        Set<Long> freqs = new HashSet<>();
        freqs.add(0L);

        final long[] freq = {0};

        Path inputPath = Paths.get(ClassLoader.getSystemResource("day1.txt").toURI());

        boolean enough = false;
        int n = 0;
        while (!enough) {
            Files.lines(inputPath)
                  .forEach(l -> {
                      freq[0] += Long.parseLong(l);
                      boolean added = freqs.add(freq[0]);
                      System.out.println(
                            "l = " + l + ", ref.freq = " + freq[0] + ",  added = " + added);
                      if (!added) {
                          System.out.println("Frequency that repeats = " + freq[0]);
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



