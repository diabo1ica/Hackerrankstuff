package Java.LegoBlocks;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int legoBlocks(int n, int m) {
        // Funni megik number
        final int MOD = 1000000007;
        
        // Represents the num of ways to build a wall of height 1
        // for each width m (array index represents m)
        List<Long> lego1 = new ArrayList<>();
        lego1.add(Long.valueOf(0));
        for (int i = 0; i <= 3; i++) {
            lego1.add((long)Math.pow(2, i));
        }
        
        // From m = 5 onwards the permutation can be calculated as
        // the sum of num of ways from the 4 width behind m
        // So with m = 5 we have lego1[4] + lego1[3] + lego1[2] + lego[1]
        for (int i = 5; i <= m; i++) {
            long numWaysM = 0;
            for (int j = 1; j <= 4; j++) {
                numWaysM += lego1.get(i - j);
            }
            lego1.add(numWaysM % MOD);
        }
        
        // Calculating the permutations for walls with height n and width m
        // can simply be done by calculating the power of the values 
        // we have obtained in lego1 to its height
        List<Long> lego2 = new ArrayList<>();
        lego2.add(Long.valueOf(0));
        for (int i = 1; i <= m; i++) {
            long value = 1;
            for (int exp = n; exp >= 1; exp--) {
                value = value * lego1.get(i) % MOD;
            }
            lego2.add(value);
        }
        
        // But now we need to get rid of the invalid walls
        // i.e.: those that has straight vertical line(s) in the wall composition
        // therefore splitting the wall into multiple walls
        List<Long> lego3 = new ArrayList<>();
        lego3.add(Long.valueOf(0));
        lego3.add(Long.valueOf(1));
        
        // Now the algorithm to compute this can be summed as follows
        // [Total Invalid] += [Valid permutations] * [Valid + Invalid permutations]
        // [Total Valid]   = [Valid + Invalid permutations] - [Total Invalid]
        // Suppose we want to calculate valid wall m = 5
        // Then we do for i = 0 up to m
        // sum += lego3[i] * lego2[m - i]
        // Which gives us the total invalid permutations
        // Then we just need to subtract
        // lego3[m] = lego2 - sum
        for (int i = 2; i <= m; i++) {
            long sumInvalid = 0;
            for (int j = 1; j < i; j++) {
                sumInvalid += (lego3.get(j) * lego2.get(i - j));
                sumInvalid %= MOD; 
            }
            long sumValid = lego2.get(i) - sumInvalid + MOD;
            lego3.add(sumValid % MOD);
        }
        long result = lego3.get(m);
        return (int) result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
