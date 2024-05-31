package Java.TowerBreakers;

import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    // We know that both players will play optimally we assume that all players 
    // will go YOLO fuck it we ball and reduce each tower to m = 1 on their turn

    // (P.S: its kinda complicated to explain why even if both players play carefully
    // and don't go full yolo by only reducing the towers by minimal values, the result won't
    // change, so just trust me bro (Gary, 2024))

    // Since all towers are of equal height m
    // Player 2 wins by default if:
    // 1. If all towers m = 1
    // 2. If n is an odd number
    public static int towerBreakers(int n, int m) {
        if (m == 1 || n % 2 == 0) {
            return 2;
        }
        return 1;
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

                int result = Result.towerBreakers(n, m);

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

