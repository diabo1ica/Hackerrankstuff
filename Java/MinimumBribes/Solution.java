package Java.MinimumBribes;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    // Algorithm = use for loop, for each value check number of values to the right that is less
    // than current value, these numbers represents bribes, we can use a nested for loop
    // to do this, however this results in a O(n^2) time complexity.

    // Using nested loops will only pass 60% of the test cases so here we substitute
    // the second for loop with the TreeSet.headSet() method
    // headSet(num) will return a list of numbers greater than num and it runs in O(logn)
    // So by using this method instead of iterating through the list manually we now have
    // An algorithm with time complexity O(nlogn)

    public static void minimumBribes(List<Integer> q) {
        long bribes = 0;
        TreeSet<Integer> ts = new TreeSet<>();

        // Populate the treeset
        for (int person: q) {
            ts.add(person);
        }

        // In the order shown in q, check how many numbers are larger than person
        for (int person: q) {
            int bribe = ts.headSet(person, false).size();
            if (bribe > 2) {
                System.out.println("Too chaotic");
                return;
            }
            bribes += bribe;
            ts.remove(person);
        }
        System.out.println(bribes);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

