package Java.BalancedBrackets;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Initialize hasmap mapping a opening bracket (as key)
        // to its associated closing bracket (as value)
        HashMap<String, String> hm = new HashMap<>();
        hm.put(")", "(");
        hm.put("}", "{");
        hm.put("]", "[");
        
        // The right-most opening bracket must be the same type as
        // the left-most closing bracket, therefore we use a stack
        // and its First in first out data structure to keep track of
        // the right-most opening bracket 
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            // If char is a opening bracket, add to stack
            if (c.equals("(") || c.equals("{") || c.equals("[")) {
                stack.push(String.valueOf(c));
            } else {
                // Stack must not be empty and right-most opening bracket
                // must be of the same type of current closing bracket
                String pair = hm.get(c);
                if (!stack.isEmpty() && pair.equals(stack.peek())) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }
        // If there are leftover closing brackets then its not balanced
        return stack.isEmpty() ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

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

