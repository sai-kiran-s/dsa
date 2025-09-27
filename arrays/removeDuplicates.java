package arrays;

import java.util.Scanner;

public class removeDuplicates {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int k = removeDuplicatesFromArray(arr, n);
        for(int i = 0; i <=k; ++i) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    static int removeDuplicatesFromArray(int[] arr, int n) {
        int i = 0;
        for(int j = 1; j < n; ++j) {
            if(arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;
            }
        }
        System.out.println(i);
        return i;
    }
}
