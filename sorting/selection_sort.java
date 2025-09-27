package sorting;

import java.util.Scanner;

public class selection_sort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        for(int i=0; i<arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
    static void selectionSort(int arr[]) {
        int arrSize = arr.length;
        int min = 0;
        for(int i = 0; i<=arrSize-1; i++) {
            min = i;
            for(int j=i; j<=arrSize-2; j++) {
                if(arr[j] > arr[j+1]) {
                    min = j+1;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
