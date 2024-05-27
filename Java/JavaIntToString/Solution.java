package Java.JavaIntToString;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        if (num >= -100 && num <= 100) {
            String strNum = String.valueOf(num);
            if (strNum.equals(Integer.toString(num))) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer");
            }
        }
    }
}
