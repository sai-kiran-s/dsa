package binary_search;

import java.util.Scanner;

public class binarySearchIterative {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer target = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i< n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer index = binarySearch(arr, n, target);
        System.out.println(index);
        sc.close();
    }

    static Integer binarySearch(Integer arr[], Integer n, Integer target) {
        Integer low = 0, high = n-1;
        while(low <= high) {
            Integer mid = low + (high - low)/2;
            if(target == arr[mid]) {
                return mid;
            }
            else if(target > arr[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
    
}
