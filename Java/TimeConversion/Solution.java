package Java.TimeConversion;

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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
        String str = s.substring(0, s.length()-2);
        String[] splitStr = str.split("\\:");
        
        String hours = splitStr[0];
        String minutes = splitStr[1];
        String seconds = splitStr[2];

        if (s.contains("PM")) {
            if (!hours.equals(String.valueOf(12))) {
                int value = Integer.valueOf(hours) + 12;
                hours = String.valueOf(value);
            }
        } else {
            if (hours.equals(String.valueOf(12))) {
                hours = "00";
            }
        }
        return hours + ":" + minutes + ":" + seconds;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

