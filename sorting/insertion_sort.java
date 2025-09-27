package sorting;

import java.util.Scanner;

public class insertion_sort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        insertionSort(arr, n);
        for(int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    static void insertionSort(int arr[], int n) {
        for(int i = 1; i < n; ++i) {
            for(int j = i; j > 0; --j) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else {
                    break;
                }
            }
        }

    }
}
