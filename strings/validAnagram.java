package strings;

import java.util.Scanner;

public class validAnagram {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(isAnagram(s, t));
        sc.close();
    }

    static boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(sLength != tLength) {
            return false;
        }
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            freq[c - 'a']--;
        }
        for(int i : freq) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}
