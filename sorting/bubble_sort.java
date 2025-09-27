package sorting;

import java.util.Scanner;

public class bubble_sort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr, n);
        for(int i = 0; i<n; ++i) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    static void bubbleSort(int arr[], int n) {
        boolean didSwap = false;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n-i-1 ; ++j) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println("ran");
                    didSwap = true;
                }
            }
            if(!didSwap) {
                break;
            }
        }
    }
    
}
