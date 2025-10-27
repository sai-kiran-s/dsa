package binary_search;

import java.util.Scanner;
import java.util.Arrays;

public class placeAggressiveCows {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(aggressiveCows(arr, k, n));
        sc.close();
    }

    static int aggressiveCows(int arr[], int k, int n) {
        Arrays.sort(arr);
        int low = 1, high = findHigh(arr, n);
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isPossible(arr, mid, n, k)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return high;
    }

    static int findHigh(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i: arr) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        return max - min;
    }

    static boolean isPossible(int arr[], int mid, int n, int k) {
        int countCows = 1, lastCow = arr[0];
        for(int i = 1; i<n; ++i) {
            if(arr[i] - lastCow >= mid) {
                countCows += 1;
                lastCow = arr[i];
            }
            if(countCows == k) {
                return true;
            }
        }
        return false;
    }
}
