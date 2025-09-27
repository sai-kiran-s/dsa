package sorting;

import java.util.Scanner;

public class quick_sort {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n-1);
        for(int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    static void quickSort(int arr[], int low, int high) {
        if(low < high) {
            int partition = getPartition(arr, low, high);
            quickSort(arr, low, partition-1);
            quickSort(arr, partition+1, high); 
        }
    }
    
    static int getPartition(int arr[], int low, int high) {
        int pivot = low;
        int i = low;
        int j = high;
        while( i < j ){
            while( arr[i] <= arr[pivot] && i < high) {
                i++;
            }

            while( arr[j] > arr[pivot] && j > low) {
                j--;
            }
            if(i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;
        return j;
    }
}
