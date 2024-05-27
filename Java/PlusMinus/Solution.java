package Java.PlusMinus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        float pos = 0;
        float neg = 0;
        float zero = 0;
        for (int num: arr) {
            if (num > 0) pos++;
            else if (num < 0) neg++;
            else zero++;
        }
        int length = arr.size();
        System.out.println(String.format("%.6f", pos/length));
        System.out.println(String.format("%.6f", neg/length));
        System.out.println(String.format("%.6f", zero/length));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

