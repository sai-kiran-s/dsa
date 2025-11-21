package strings;

import java.util.Scanner;

public class sumOfBeautyOfSubstrings {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(beautySum(s));
        sc.close();
    }

    static int beautySum(String s) {
         int sLength = s.length();
         int result = 0;
         for(int i = 0; i < sLength; ++i) {
            int[] count = new int[27];
            for(int j = i; j < sLength; ++j) {
                char c = s.charAt(j);
                count[c - 'a'] += 1;

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for(int value : count) {
                    if(value == 0) {
                        continue;
                    }
                    max = Math.max(max, value);
                    min = Math.min(min, value);
                }
                result += max - min;
            }
         }
         return result;
    }
}
