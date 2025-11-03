package binary_search;

import java.util.Scanner;

public class medianOfTwoSortedArrays {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        Integer m = sc.nextInt();
        Integer n = sc.nextInt();
        int arr1[] = new int[m];
        int arr2[] = new int[n];
        for(int i=0; i<m; ++i) {
            arr1[i] = sc.nextInt();
        }
        for(int i=0; i<n; ++i) {
            arr2[i] = sc.nextInt();
        }
        System.out.println(findMedianOfTwoSortedArrays(arr1, arr2, m, n));
        sc.close();

    }

    static double findMedianOfTwoSortedArrays(int[] arr1, int[] arr2, int m, int n) {
        if(n<m) {
            return findMedianOfTwoSortedArrays(arr2, arr1, n, m);
        }
        int leftCapacity = (m+n+1)/2;
        int low = 0;
        int high = leftCapacity;
        while(low <= high) {
            int mid1 = low + (high - low)/2;
            int mid2 = leftCapacity - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 - 1 >= 0) {
                l1 = arr1[mid1 - 1];
            }
            if(mid2 - 1 >= 0) {
                l2 = arr2[mid2 - 1];
            }
            if(mid1 < m) {
                r1 = arr1[mid1];
            }
            if(mid2 < n) {
                r2 = arr2[mid2];
            }
            if(l1 <= r2 && l2 <= r1) {
                if((m+n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                else {
                    return Math.max(l1, l2);
                }
            } else if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
