package strings;

import java.util.Scanner;

public class longestPalindromicSubstring {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(findLongestPalindromicSubstring(s));
        sc.close();
    }

    static String findLongestPalindromicSubstring(String s) {
        int sLength = s.length();
        if(sLength == 0) {
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < sLength; ++i) {
            int oddLength = findLongest(s, i - 1, i + 1, sLength);
            int evenLength = findLongest(s, i, i + 1, sLength);
            int maxLength = Math.max(oddLength, evenLength);
            if(maxLength > end - start + 1) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    static int findLongest(String s, int i, int j, int sLength) {
        while(i >= 0 && j < sLength && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
    
}
