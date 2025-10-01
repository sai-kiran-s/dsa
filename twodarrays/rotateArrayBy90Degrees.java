package twodarrays;

import java.util.Scanner;

public class rotateArrayBy90Degrees {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                arr[i][j] = sc.nextInt();
            }
        }
        rotateArrayBy90DegreesInPlace(arr, m, n);
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        sc.close();
    }

    static void rotateArrayBy90DegreesInPlace(int arr[][], int m, int n) {
        for(int i=0; i<m; ++i) {
            for(int j=i+1; j<n; ++j) {
                swap(arr, i, j);
            }
        }
        for(int i=0; i<m; ++i) {
            reverse(arr[i], n);
        }
    }

    static void reverse(int arr[], int n) {
        int left = 0, right = n-1;
        while(left<right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    static void swap(int arr[][], int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
