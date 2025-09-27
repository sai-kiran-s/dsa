package arrays;

import java.util.Scanner;

public class longestSubarrayWithSumKPosZeros {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        int result = getLongestSubArrayLengthWithSumKPosZeros(arr, n, k);
        System.out.print(result);
        sc.close();
    }

    static int getLongestSubArrayLengthWithSumKPosZeros(int arr[], int n, int k) {
        int sum = arr[0];
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right < n) {
            while(left <= right && sum > k) {
                sum -= arr[left];
                left += 1;
            }
            if(sum == k) {
                maxLength = Integer.max(maxLength, right - left + 1);
            }
            right += 1;
            if(right < n) {
                sum += arr[right];
            }
        }
        return maxLength;
    }
}
