package binary_search;

import java.util.Scanner;

public class searchElementRotatedSortedArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer target = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer index = findElement(arr, n, target);
        System.out.println(index);
        sc.close();
    }

    static Integer findElement(Integer arr[], Integer n, Integer target) {
        Integer low = 0, high = n-1;
        while(low <= high) {
            Integer mid = low + (high - low)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[low] <= arr[mid]) {
                if(arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if(arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
