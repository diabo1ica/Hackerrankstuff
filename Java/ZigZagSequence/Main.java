package Java.ZigZagSequence;

import java.util.*;

public class Main {
    
    public static void main (String[] args) throws java.lang.Exception {
        Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
             int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = kb.nextInt();
            }
            findZigZagSequence(a, n);
        }
   }
   
    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a); // Sort array
        int mid = n / 2; // Get middle index (modified)
        
        // Switch middle index and last index from sorted array
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;
    
        // Now the first half of the array is sorted
        // in increasing order, which means that half
        // of the zig zag is done
        // Now we only need to sort the latter half
        // We do this by swapping the values
        
        // Mark the index after the middle index
        int st = mid + 1;
        // Mark the index before the last index 
        int ed = n - 2; // modified
        
        // Swap st and ed then increment st and decrement ed
        // This shrinks the partition allowing us to
        // swap the right numbers
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1; // modified
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
