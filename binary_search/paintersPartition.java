package binary_search;

import java.util.Scanner;

public class paintersPartition {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findMinTimeForPainters(arr, k, n));
        sc.close();
    }

    static int findMinTimeForPainters(int[] arr, int k, int n) {
        int[] highAndLow = getHighAndLow(arr);
        int low = highAndLow[0];
        int high = highAndLow[1];
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(isMidPossible(arr, mid, k, n)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int[] getHighAndLow(int[] arr) {
        int sum = 0, min = Integer.MAX_VALUE;
        for(int i: arr) {
            sum += i;
            min = Math.min(min, i);
        }
        return new int[]{min, sum};
    }

    static boolean isMidPossible(int[] arr, int mid, int k, int n) {
        int countPainters = 1, sum = 0;
        for(int i : arr) {
            if(sum + i <= mid) {
                sum += i;
            }
            else {
                countPainters +=1;
                sum = i;
            }
        }
        if(countPainters == k) {
            return true;
        }
        return false;
    }
}
