package Java.SimpleTextEditor;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        Stack<String> contentHistory = new Stack<>();
        
        for (int i = 0; i < q; i++) {
            int operation = sc.nextInt();
            // append
            if (operation == 1) {
                String str = sc.next();
                contentHistory.push(sb.toString());
                sb.append(str);
            }
            // delete
            else if (operation == 2) {
                int num = sc.nextInt();
                int start = sb.length() - num;
                contentHistory.push(sb.toString());
                sb.delete(start, sb.length());
            }
            // print
            else if (operation == 3) {
                int index = sc.nextInt();
                System.out.println(sb.charAt(index - 1));
            }
            // undo
            else if (operation == 4) {
                sb = new StringBuilder();
                sb.append(contentHistory.pop());
                //System.out.println("sb :"+sb.toString());
            }
        }
        sc.close();
    }
}
