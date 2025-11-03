package binary_search;

import java.util.Scanner;

public class kthElementOfTwoSortedArrays {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i = 0;i<n; ++i) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int arr2[] = new int[m];
        for(int i = 0;i<m; ++i) {
            arr2[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(kthElement(arr1, arr2, n, m, k));
        sc.close();
    }

    public static int kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        if(m < n) {
            return kthElement(arr2, arr1, m, n, k);
        }
        int leftCapacity = k;
        int low = 0, high = leftCapacity;
        while(low <= high) {
            int mid1 = low + (high - low)/2;
            int mid2 = leftCapacity - mid1;
            if(mid2 > m && mid1 < n) {
                low = mid1 + 1;
                continue;
            }
            if(mid1 > n && mid2 < m) {
                high = mid1 - 1;
                continue;
            }
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 - 1 >= 0) l1 = arr1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = arr2[mid2 - 1];
            if(mid1 < n) r1 = arr1[mid1];
            if(mid2 < m) r2 = arr2[mid2];
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if(l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
