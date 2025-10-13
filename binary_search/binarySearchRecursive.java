package binary_search;

import java.util.Scanner;

public class binarySearchRecursive {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer target = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer index = binarySearch(arr, 0, n-1, target);
        System.out.println(index);
        sc.close();
    }

    static Integer binarySearch(Integer arr[], Integer low, Integer high, Integer target) {
        if(low > high) {
            return -1;
        }
        Integer mid = low + (high - low)/2;
        if(target == arr[mid]) {
            return mid;
        }
        else if(target > arr[mid]) {
            return binarySearch(arr, mid+1, high, target);
        }
        else {
            return binarySearch(arr, low, mid-1, target);
        }
    }
}
