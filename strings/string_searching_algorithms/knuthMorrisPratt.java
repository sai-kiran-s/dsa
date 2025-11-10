package strings.string_searching_algorithms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class knuthMorrisPratt {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();
        Iterator<Integer> i = findOccurenceIndices(text, pattern).iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
        sc.close();
    }

    static ArrayList<Integer> findOccurenceIndices(String text, String pattern) {
        ArrayList<Integer> results = new ArrayList<>();
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
                    results.add(i-j);
                    j = lps[j-1];
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
        return results;
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
}
