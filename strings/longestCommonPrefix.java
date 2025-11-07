package strings;

import java.util.Arrays;
import java.util.Scanner;

public class longestCommonPrefix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for(int i = 0 ; i < n; ++i) {
            strs[i] = sc.next();
        }
        System.out.println(findLongestCommonPrefix(strs));
        sc.close();
    }

    static String findLongestCommonPrefix(String[] strs) {
        StringBuilder longestCommonPrefix = new StringBuilder();
        Arrays.sort(strs);
        String firstString = strs[0];
        String lastString = strs[strs.length - 1];
        int minLength = Math.min(firstString.length(), lastString.length());
        int i = 0;
        while(i < minLength) {
            char c1 = firstString.charAt(i);
            if(c1 == lastString.charAt(i)) {
                longestCommonPrefix.append(c1);
            }
            else {
                break;
            }
            i+=1;
        }
        return longestCommonPrefix.toString();
    }
}
