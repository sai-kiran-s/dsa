package arrays;

import java.util.Scanner;

public class sort0s1s2s {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i=0; i<n; ++i){
            arr[i] = sc.nextInt();
        }
        sortArray(arr, n);
        for(Integer i=0; i<n; ++i) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    static void sortArray(Integer arr[], Integer n) {
        Integer low = 0, mid = 0, high = n-1;
        while(mid <= high) {
            if(arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    static void swap(Integer arr[], Integer a, Integer b) {
        Integer temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp; 
    }
}
