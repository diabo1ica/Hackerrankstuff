package Java.TruckTour;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    // Time complexity O(n)
    // Each list in the parameter has exactly 2 elements
    // Performing a for loop on petrolpumps gives O(2*n) = O(n)
    public static int truckTour(List<List<Integer>> petrolpumps) {
    // Write your code here
        int fuel = 0;
        int smallestIndex = 0;
        for (int i = 0; i < petrolpumps.size(); i++) {
            List<Integer> pump = petrolpumps.get(i);
            int petrol = pump.get(0);
            int distance = pump.get(1);
            
            fuel += petrol;
            
            // If fuel cannot cover distance to next pump
            // reset fuel and move onto next index
            // else deduct current fuel with distance to next pump
            if (fuel < distance) {
                if (i == petrolpumps.size() - 1) return i;
                fuel = 0;
                smallestIndex = i + 1;
            } else {
                fuel -= distance;
            }
        }
        return smallestIndex;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
