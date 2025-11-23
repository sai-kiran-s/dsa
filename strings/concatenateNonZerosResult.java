package strings;

import java.util.Scanner;
import java.util.HashMap;

public class concatenateNonZerosResult {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        int[][] queries = new int[n][3];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < 2; ++j) {
                queries[i][j] = sc.nextInt();
            }
        }
        int[] results = sumAndMultiply(s, queries);
        for(int i = 0; i < results.length; ++i) {
            System.out.println(results[i]);
        }
        sc.close();
    }

    static int[] sumAndMultiply(String s, int[][] queries) {
        long MODULO = 1000000007;
        long[][] hash = new long[s.length()][3];
        long tempLen = 0, tempSum = 0, tempVal = 0;
        HashMap<Long, Long> multiplicand = computeHash(s, hash, tempLen, tempSum, tempVal, MODULO);
        int[] results = new int[queries.length];
        int length = 0;
        for(int[] query : queries) {
            results[length++] = getResult(hash, MODULO, query[0], query[1], multiplicand);
        }
        return results;
    }

    static void printHash(String s, long[][] hash) {
        for(int k = 0; k < s.length(); ++k) {
            for(int l = 0; l < 3; ++l) {
                System.out.print(hash[k][l] + " ");
            }
            System.out.println();
        }
    }

    static HashMap<Long, Long> computeHash(String s, long[][] hash, long tempLen, long tempSum, long tempVal, long MODULO) {
        HashMap<Long, Long> multiplicand = new HashMap<>();
        multiplicand.put(0L, 1L);
        long multiplicandVal = 1;
        for(int k = 0; k < s.length(); ++k) {
            char c = s.charAt(k);
            if(c != '0') {
                tempVal = (tempVal + (c - '0')) % MODULO;
                tempSum = (tempSum + (c - '0')) % MODULO;
                tempLen += 1;
                hash[k] = new long[]{tempVal, tempSum, tempLen};
                tempVal = (tempVal * 10) % MODULO;
                multiplicandVal = (multiplicandVal * 10) % MODULO;
                multiplicand.put(tempLen, multiplicandVal);
            } else {
                if(k != 0) {
                    hash[k] = hash[k-1];
                }
                else {
                    hash[k] = new long[]{tempVal, tempSum, tempLen};
                }
            }
        }
        return multiplicand;
    }

    static int getResult(long[][] hash, long MODULO, int i, int j, HashMap<Long, Long> multiplicandHash) {
        long result = 0;
        if(i == 0) {
            result = hash[j][1] * hash[j][0] % MODULO;
        }
        else {
            long sumDiff = (hash[j][1] - hash[i - 1][1] + MODULO ) % MODULO;
            long lenDiff = (hash[j][2] - hash[i - 1][2] + MODULO) % MODULO;
            long multiplicand = multiplicandHash.get(lenDiff);
            long hashIMultiplicand = (hash[i - 1][0] * multiplicand) % MODULO;
            long valDiff = (hash[j][0] - hashIMultiplicand + MODULO) % MODULO;
            result = (valDiff * sumDiff) % MODULO;
        }
        return (int) result;
    }
}
