package arrays;

import java.util.Scanner;
import java.util.HashMap;

public class longestSubarrayWithSumKNeg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        int result = getLongestSubArrayLengthWithSumKNeg(arr, n, k);
        System.out.print(result);
        sc.close();
    }

    static int getLongestSubArrayLengthWithSumKNeg(int arr[], int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for(int i=0; i<n; ++i) {
            sum += arr[i];
            if(sum == k) {
                maxLength = Integer.max(maxLength, i+1);
            }
            int rem = sum - k;
            Integer index = hm.get(rem);
            if(index != null) {
                maxLength = Integer.max(maxLength, i - index +1);
            }
            if(hm.get(sum) == null) {
                hm.put(sum, i);
            }
        }
        return maxLength;
    }


}
