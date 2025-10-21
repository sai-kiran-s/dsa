package binary_search;

import java.util.Scanner;

public class findSmallestDivisorGivenThreshold {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        int threshold = sc.nextInt();
        System.out.println(findSmallestDivisor(arr, n, threshold));
        sc.close();
    }

    static int findSmallestDivisor(int[] arr, int n, int threshold) {
        int max = findMax(arr, n);
        int low = 1, high = max;
        while(low <= high) {
            int mid = low + (high - low)/2;
            boolean isMidDivisorLessEqualThreshold = isMidDivisorLessEqualThreshold(arr, n, threshold, mid);
            if(isMidDivisorLessEqualThreshold) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int findMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for(int ele : arr) {
            max = Math.max(max, ele);
        }
        return max;
    }

    static boolean isMidDivisorLessEqualThreshold(int[] arr, int n, int threshold, int mid) {
        int sum = 0;
        for(int ele : arr) {
            sum += (int)Math.ceil((double)ele/mid);
        }
        if(sum <= threshold) {
            return true;
        }
        return false;
    }
}
