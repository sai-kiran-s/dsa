package arrays;

import java.util.Scanner;

public class findMissingNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n-1; ++i) {
            arr[i] = sc.nextInt();
        }
        findMissingNumberFromArray(arr, n);
        sc.close();
    }

    static void findMissingNumberFromArray(int arr[], int n) {
        int xor1 = 0;
        int xor2 = 0;
        for(int i = 0; i<n-1 ; ++i) {
            xor1 = xor1^arr[i];
            xor2 = xor2^(i+1);
        }
        xor2 = xor2^n;
        System.out.println(xor1^xor2);
    }

}
