package arrays;

import java.util.Scanner;

public class secondLargestElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.println(secondLargest(arr, n));
        sc.close();
    }

    static int secondLargest(int arr[], int n) {
        int largest = Integer.MIN_VALUE;
        int sLargest = Integer.MIN_VALUE;
        for(int i = 0; i < n ; ++i ){
            if(arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            }
            if(arr[i] < largest && arr[i] > sLargest) {
                sLargest = arr[i];
            }
        }
        return sLargest;
    }
    
}
