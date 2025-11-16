package strings;

import java.util.Scanner;

public class numberOfSubstrings {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(numSub(s));
        sc.close();
    }

    public static int numSub(String s) {
        long result = 0;
        int i = 0, sLength = s.length(), count = 0;
        final int MOD = 1_000_000_007;
        while(i < sLength) {
            while(i < sLength && s.charAt(i) == '0') {
                if(count > 0) {
                    count = 0;
                }
                i += 1;
            }
            while(i < sLength && s.charAt(i) == '1') {
                count += 1;
                i += 1;
            }
            long a, b;
            if(count % 2 == 0) {
                a = count / 2;
                b = count + 1;
            }
            else {
                a = (count + 1) / 2;
                b = count;
            }
            long c = a * b;
            long cMod = c % MOD;
            result = (result + cMod) % MOD;
        }
        return (int)result;
    }
}
