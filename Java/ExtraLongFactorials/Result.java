package Java.ExtraLongFactorials;

import java.math.*;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
    // Write your code here
        BigInteger num = BigInteger.valueOf(n);
        for(int i = n-1; i > 0; i--){
            num = num.multiply(BigInteger.valueOf(i));
        }
        System.out.println(num);
    }

}

// public class Solution {
//     public static void main(String[] args) throws IOException {
//         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//         int n = Integer.parseInt(bufferedReader.readLine().trim());

//         Result.extraLongFactorials(n);

//         bufferedReader.close();
//     }
// }

