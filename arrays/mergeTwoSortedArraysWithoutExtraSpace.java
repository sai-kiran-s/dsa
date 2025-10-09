package arrays;

import java.util.Scanner;

public class mergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for(int i=0; i<m; ++i) {
            arr1[i] = sc.nextInt();
        }
        for(int i=0; i<n; ++i) {
            arr2[i] = sc.nextInt();
        }
        int len = m+n;
        int gap = len/2 + len%2;
        while(gap > 0) {
            int left = 0;
            int right = gap;
            while(right < len) {
                if(left < m && right < m)
                    swapIfGreater(arr1, arr1, left, right);
                else if(left < m && right >=m)
                    swapIfGreater(arr1, arr2, left, right-m);
                else if(left >= m && right >=m)
                    swapIfGreater(arr2, arr2, left-m, right-m);
                left++;
                right++;
            }
            if(gap == 1)
                break;
            gap = gap/2 + gap%2;
        }
        for(int i=0; i<m+n; ++i) {
            if(i<m) System.out.print(arr1[i] + " ");
            else System.out.print(arr2[i-m] + " ");
        }
        sc.close();
    }
    
    static void swapIfGreater(int[] arr1, int[] arr2, int m, int n) {
        if(arr1[m] > arr2[n]) {
            int temp = arr1[m];
            arr1[m] = arr2[n];
            arr2[n] = temp;
        }
    }
}
