package Java.CaesarCipher;

import java.io.*;

class Result {
    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char shfitedChar = ' ';
            if (isAlphabet(c)) {
                if (Character.isUpperCase(c)) {
                    shfitedChar = encrypt(alphabet.toUpperCase(), c, k);
                } else {
                    shfitedChar = encrypt(alphabet, c, k);
                }
            } else {
                shfitedChar = c;
            }

            cipher.append(shfitedChar);
        }
        return cipher.toString();
    }

    public static boolean isAlphabet(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }

    public static char encrypt(String alphabet, char c, int shift) {
        int index = alphabet.indexOf(c);
        int shiftedIndex = (index + shift) % 26;
        return alphabet.charAt(shiftedIndex);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

