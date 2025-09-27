package arrays;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class maxSubArraySum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> maxSubArraySum = findMaxSubArraySum(arr, n);
        System.out.print(maxSubArraySum);
        sc.close();
    }

    static ArrayList<Integer> findMaxSubArraySum(Integer[] arr, Integer n) {
        ArrayList<Integer> maxSubArraySum = new ArrayList<>();
        Integer maxSum = 0, maxStart = Integer.MIN_VALUE, maxEnd = Integer.MIN_VALUE;
        Integer sum = 0, start = 0;
        for(Integer i=0; i<n; ++i) {
            if(sum == 0) {
                start = i;
            }
            sum+=arr[i];
            if(sum > maxSum) {
                maxSum = sum;
                maxStart = start;
                maxEnd = i;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        maxSubArraySum.addAll(List.of(maxSum, maxStart, maxEnd));
        return maxSubArraySum;
    }
}
