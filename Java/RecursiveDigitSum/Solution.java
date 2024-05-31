package Java.RecursiveDigitSum;

import java.io.*;

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        // We use long here IN CASE if the sum exceeds the integer limit
        // which is veeery possible cause this is hackerank we talking about
        long sum = 0;
        for (char num: n.toCharArray()) {
            sum += Character.getNumericValue(num);
        }
        sum = sum * k;
        System.out.println(sum);
        
        if (sum < 10) return (int)sum;
        
        n = String.valueOf(sum);
        return superDigit(n, 1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

