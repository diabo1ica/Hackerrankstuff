package Java.StaticInitBlock;

import java.io.*;
import java.util.*;

public class Solution {
    public static int b;
    public static int h;
    public static int area = 0;
    public static boolean valid;

    static {
        try {
            Scanner sc = new Scanner(System.in);
            b = sc.nextInt();
            h = sc.nextInt();
            sc.close();

            if (b > 0 && h > 0) {
                valid = true;
                area = b * h;
            } else {
                valid = false;
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        if (valid) {
            System.out.println(area);
        }
    }
}