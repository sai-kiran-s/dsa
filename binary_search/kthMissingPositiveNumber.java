package binary_search;

import java.util.Scanner;

public class kthMissingPositiveNumber {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findKthMissingPositiveNumber(arr, n ,k));
        sc.close();
    }

    static int findKthMissingPositiveNumber(int arr[], int n, int k) {
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] - 1 > mid) {
                if(arr[mid] - 1 - mid < k) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            else {
                low = mid + 1;
            }
        }
        return low + k;
    }
    
}
