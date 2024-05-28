package Java.LonelyInteger;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    // The XOR operator takes two integers and performs the XOR operation on each pair 
    // of corresponding bits. The result is a new integer where each bit is 1 if the 
    // bits of the operands are different, and 0 if they are the same.
    // Example: 
    // 5 ^ 3 = 0101 ^ 0011 results in 0110, which is 6 in decimal.

    // How the XOR Operation Helps
    // The XOR operation has several useful properties:
    // 1.   XOR of a number with itself is 0: a ^ a = 0
    // 2.   XOR of a number with 0 is the number itself: a ^ 0 = a
    // 3.   XOR is commutative and associative, meaning the order of operations does not matter.
    
    // Given these properties, when you XOR all numbers in the list:
    // All numbers that appear twice will cancel each other out because a ^ a = 0.
    // The number that appears only once will be XORed with 0 (since it has no pair), 
    // leaving it as the result.

    public static int lonelyinteger(List<Integer> a) {
    // Write your code here
        int lonely = 0;
        for (int integer: a) {
            lonely = lonely ^ integer;
        }
        return lonely;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
