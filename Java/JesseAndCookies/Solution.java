package Java.JesseAndCookies;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        // An Integer Priority queue pops out the min integer when poll is called
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num: A) {
            q.add(num);
        }
        
        int iterations = 0;
        
        // While there are at least 2 cookies and there is one with
        // sweetness below the threshold value k
        // Poll 2 least cookies from the priority queue, combine them
        // then add the newly created cookie in the priority queue
        while (q.size() >= 2 && q.peek() < k) {
            int cookie1 = q.poll();
            int cookie2 = q.poll();
            int newCookie = cookie1 + (cookie2 * 2);
            q.add(newCookie);
            iterations++;
        }

        // If cookies less than 2 and is above k, return iterations
        if (q.peek() >= k) return iterations;
        // else if below k return -1
        return -1;

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
