package arrays;

import java.util.Scanner;

public class rotateArrayByKPlaces {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        // leftRotateArray(arr, n, k);
        // for(int i = 0; i< n; ++i) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
        rightRotateArray(arr, n, k);
        for(int i = 0; i< n; ++i) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    static void leftRotateArray(int arr[], int n, int k) {
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, n-1);
        reverseArray(arr, 0, n-1);
    }

    static void rightRotateArray(int arr[], int n, int k) {
        reverseArray(arr, 0, n-k-1);
        reverseArray(arr, n-k, n-1);
        reverseArray(arr, 0, n-1);
    }

    static void reverseArray(int arr[], int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start += 1;
            end -= 1;
        }
    }
    
}
