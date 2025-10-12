package arrays;

import java.util.Scanner;

public class maxProductSubarray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer maxProductSubarray = findMaxProductSubarray(arr, n);
        System.out.println(maxProductSubarray);
        sc.close();
    }

    static Integer findMaxProductSubarray(Integer arr[], Integer n) {
        Integer maxProductSubarray = Integer.MIN_VALUE;
        Integer preProduct = 1;
        Integer sufProduct = 1;
        for(Integer i = 0; i<n; ++i) {
            if(preProduct == 0) preProduct = 1;
            if(sufProduct == 0) sufProduct = 1;

            preProduct *= arr[i];
            sufProduct *= arr[n-i-1];

            maxProductSubarray = Math.max(preProduct, maxProductSubarray);
            maxProductSubarray = Math.max(sufProduct, maxProductSubarray);
        }
        return maxProductSubarray;
    }
}
