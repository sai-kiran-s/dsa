package strings;

import java.util.Scanner;

public class isRotateString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String goal = sc.next();
        System.out.println(checkRotateString(s, goal));
        sc.close();
    }

    static boolean doesTextContainPattern(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();

        int[] lps = new int[patternLength];
        constructLps(pattern, lps, patternLength);

        int i = 0, j = 0;
        while(i < textLength) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if(j == patternLength) {
                    return true;
                }
            }
            else {
                if(j == 0) {
                    i++;
                }
                else {
                    j = lps[j-1];
                }
            }
        }
        return false;
    }

    static void constructLps(String pattern, int[] lps, int patternLength) {
        int len = 0, i = 1;
        while(i < patternLength) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len == 0) {
                    lps[i] = 0;
                    i++;
                }
                else {
                    len = lps[len - 1];
                }
            }
        }
    }

    static boolean checkRotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String temp = s + s;
        return doesTextContainPattern(temp, goal);
    }
}
