package binary_search;

import java.util.Scanner;

public class lowerBound {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer x = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer lowerBound = findLowerBound(arr, n, x);
        System.out.println(lowerBound);
        sc.close();
    }

    static Integer findLowerBound(Integer arr[], Integer n, Integer x) {
        Integer low = 0, high = n-1;
        Integer ans = n;
        while(low <= high) {
            Integer mid = low + (high-low)/2;
            if(arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
