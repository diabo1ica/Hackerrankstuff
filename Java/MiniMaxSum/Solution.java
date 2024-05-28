package Java.MiniMaxSum;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // First Attempt O(2*n*logn)
        // O(nlogn)
        // List<Long> list = arr.stream().sorted((a, b)-> a-b).map(Long::valueOf).collect(Collectors.toList());
        // O(nlogn)
        // long sum = arr.stream().sorted((a, b)-> a-b).mapToLong(Integer::longValue).sum();
        // long max = sum - list.get(0);
        // long min = sum - list.get(4);
        // System.out.println(max + " " + min);

        // O(n) Solution
        LongSummaryStatistics est = arr.stream().collect(Collectors.summarizingLong(Integer::longValue));
        long max = est.getSum() - est.getMax();
        long min = est.getSum() - est.getMin();
        System.out.println(max + " " + min);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

