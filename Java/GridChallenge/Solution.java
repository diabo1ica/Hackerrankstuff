package Java.GridChallenge;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
    // Write your code here
        List<String> sortedGrid = new ArrayList<>();
        // Sort each row
        for (String str: grid) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            sortedGrid.add(new String(characters));
        }
        
        // Compare char at {row} with {row + 1} within the same column
        // Then move on to next column until last column
        // repeat in increasing row until the last row

        // Because we check the row below boundary is set to the second last row
        for (int row = 0; row < grid.size() - 1; row++) {
            for (int col = 0; col < grid.get(0).length(); col++) {
                char top = sortedGrid.get(row).charAt(col);
                char bot = sortedGrid.get(row + 1).charAt(col);
                if (top > bot) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

