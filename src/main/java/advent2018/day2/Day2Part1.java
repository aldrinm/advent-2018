package advent2018.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day2Part1 {

    public static void main(String[] args) throws IOException, URISyntaxException {

        AtomicLong twosCount = new AtomicLong();
        AtomicLong threesCount = new AtomicLong();
        Path inputPath = Paths.get(ClassLoader.getSystemResource("day2.txt").toURI());

        Files.lines(inputPath)
              .forEach(l -> {
                  Map<String, Long> charFreq = Arrays.stream(l.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                  if (charFreq.values().stream()
                        .anyMatch(f -> f == 2)) {
                      twosCount.getAndIncrement();
                  }
                  if (charFreq.values().stream()
                        .anyMatch(f -> f == 3)) {
                      threesCount.getAndIncrement();
                  }
                  //System.out.println("charFreq = " + charFreq);
              });

        System.out.println("twosCount = " + twosCount);
        System.out.println("threesCount = " + threesCount);
        System.out.println("ChkSum = " + (twosCount.get() * threesCount.get()));
    }

}



