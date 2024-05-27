package Java.Java_types;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int myInt = scanner.nextInt();
        for (int i = 0; i < myInt; i++) {
            try {
                long num = scanner.nextLong();
                System.out.println(num + " can be fitted in:");
                // Byte
                if (num >= Byte.MIN_VALUE && num <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                // Short
                if (num >= Short.MIN_VALUE && num <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                // Integer
                if (num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                // Long
                if (num >= Long.MIN_VALUE && num <= Long.MAX_VALUE) {
                    System.out.println("* long");
                }
            } catch (Exception e) {
                System.out.println(scanner.next() + " can't be fitted anywhere.");
            }
        }
        scanner.close();
    }
}

