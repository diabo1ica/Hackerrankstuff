package Java.QueueTwoStacks;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        
        Stack<Integer> stk = new Stack<>();
        
        while (queries > 0) {
            int query = sc.nextInt();
            if (query == 1) {
                stk.push(sc.nextInt());
            } else if (query == 2) {
                stk.remove(0);
            } else if (query == 3) {
                System.out.println(stk.get(0));
            }
            queries--;
        }
        sc.close();
    }
}
