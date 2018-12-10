package advent2018.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2Part2 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Path inputPath = Paths.get(ClassLoader.getSystemResource("day2.txt").toURI());

        List<char[]> boxids = new ArrayList<>();

        //just about 250 lines in the input data, so just get it all into memory
        Files.lines(inputPath)
              .forEach(l -> boxids.add(l.toCharArray()));

        long lowestDiffCnt = Long.MAX_VALUE;
        char[] candidate1 = null, candidate2 = null;

        for (int i = 0; i < boxids.size(); i++) {
            char[] id1 = boxids.get(i);
            for (int j = i + 1; j < boxids.size(); j++) {
                int[] diffs = new int[id1.length];
                char[] id2 = boxids.get(j);
                for (int k = 0; k < id1.length; k++) {
                    char c = id1[k];
                    diffs[k] = Math.abs(id1[k] - id2[k]);
                }
                long nDiffs = Arrays.stream(diffs).filter(d -> d!= 0).count();
                if (nDiffs < lowestDiffCnt) {
                    lowestDiffCnt = nDiffs;
                    candidate1 = id1;
                    candidate2 = id2;
                }
            }
        }

        for (int i = 0; i < candidate1.length; i++) {
            if (candidate1[i] == candidate2[i]) {
                System.out.print(candidate1[i]);
            }
        }
        System.out.println();
    }

}



