package Java.Pairs;

import java.util.*;

class Solution {
    /*
    * Complete the 'pairs' function below.
    *
    * The function is expected to return an INTEGER.
    * The function accepts following parameters:
    * 1. INTEGER k
    * 2. INTEGER_ARRAY arr
    */
    // Loop through the sorted list and for each element pair1
    // find its pair2 that satisfies the condition abs(pair1-pair2) = k
    public static int pairs(int k, List<Integer> arr) {
        int pairs = 0;
        // Put all elements in list to hashmap
        // element as key and its index as value
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            hm.put(arr.get(i), i);
        }
        // Observe the equation pair1 - pair2 = k
        // then pair2 = pair1 - k
        // therefore within the hashmap we search for the key pair1 - k
        // If it exists, increase the pairs counter
        // Time complexity:
        // for loop = O(n)
        // check key = O(1)
        // total time = O(n*1) = O(n)
        for (int pair1: arr) {
            if (hm.containsKey(pair1 - k)) {
                pairs++;
            }
        }
        return pairs;
    }
}
