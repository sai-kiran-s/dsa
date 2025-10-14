package binary_search;

import java.util.Scanner;

public class firstAndLastOccurrence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer x = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer first = findFirstOccurrence(arr, n, x);
        if(first == -1) {
            System.out.println(-1 + " " + -1);
        }
        else {
            Integer last = findLastOccurrence(arr, n, x);
            System.out.println(first + " " + last);
        }
        
        sc.close();
    }

    static Integer findFirstOccurrence(Integer arr[], Integer n, Integer x) {
        Integer first = -1;
        Integer low = 0, high = n-1;
        while(low <= high) {
            Integer mid = low + (high - low)/2;
            if(arr[mid] == x) {
                first = mid;
                high = mid - 1;
            }
            else if(arr[mid] > x) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return first;
    }

    static Integer findLastOccurrence(Integer arr[], Integer n, Integer x) {
        Integer last = -1;
        Integer low = 0, high = n-1;
        while(low <= high) {
            Integer mid = low + (high - low)/2;
            if(arr[mid] == x) {
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] > x) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return last;
    }
}
