package binary_search;

import java.util.Scanner;

public class findMinimumInRotatedSortedArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer minEle = findMinimum(arr, n);
        System.out.println(minEle);
        sc.close();
    }

    static Integer findMinimum(Integer arr[], Integer n) {
        Integer ans = Integer.MAX_VALUE;
        Integer low = 0, high = n-1;
        while(low <= high) {
            Integer mid = low + (high - low)/2;
            if(arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }
            if(arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }
            else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
