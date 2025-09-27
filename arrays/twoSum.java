package arrays;

import java.util.Scanner;
import java.util.Arrays;

public class twoSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        findTwoSum(arr, n, target);
        sc.close();
    }

    static void findTwoSum(int arr[], int n, int target) {
        int left = 0;
        int right = n-1;
        int sum = 0;
        while(left < right) {
            sum = arr[left] + arr[right];
            if(sum < target) {
                left++;
            }
            else if(sum > target) {
                right--;
            }
            else {
                System.out.println( "YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
