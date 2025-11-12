package strings;

import java.util.Scanner;
import java.util.Arrays;

public class sortCharactersByFrequency {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getSortedCharactersByFrequency(s));
        sc.close();
    }

    static String getSortedCharactersByFrequency(String s) {
        StringBuilder result = new StringBuilder();
        int freq[][] = new int[63][2];
        int j = 48, i = 0;
        while(j <= 122) {
            freq[i][0] = j;
            i++;
            j++;
            if(j>57 && j<65) {
                j = 65;
            }
            if(j>90 && j<97) {
                j = 97;
            }
        }
        for(char c: s.toCharArray()) {
            int diff = c - '0';
            if((int)c >=0 && diff<=9) {
                freq[diff][1] += 1;
            }
            else if(diff >=17 && diff<=42) {
                freq[diff - 7][1] += 1;
            }
            else {
                freq[diff - 13][1] += 1;
            }
        }
        Arrays.sort(freq, (a,b)-> {
            if(b[1] == a[1]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        for(int[] a : freq) {
            if(a[1] > 0) {
                int k = a[1];
                while(k != 0) {
                    result.append((char)a[0]);
                    k -= 1;
                }
            }
        }
        return result.toString();
    }
}
