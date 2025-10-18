package binary_search;

import java.util.Scanner;

public class peakElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findPeakElement(arr, n));
        sc.close();
    }

    static Integer findPeakElement(Integer arr[], Integer n) {
        if(n == 0) return -1;
        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;

        Integer low = 1, high = n-2;
        while(low<=high) {
            Integer mid = low + (high - low)/2;
            if((arr[mid] > arr[mid-1]) && (arr[mid] > arr[mid+1]))
                return mid;
            else if(arr[mid] > arr[mid-1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
