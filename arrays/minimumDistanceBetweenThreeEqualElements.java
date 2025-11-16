package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class minimumDistanceBetweenThreeEqualElements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        System.out.println(minimumDistance(nums));
        sc.close();
    }

    static int minimumDistance(int[] nums) {
        int numsLength = nums.length;
        if(numsLength < 3) {
            return -1;
        }
        int[][] arr = new int[numsLength][2];
        int i= 0;
        for(; i < numsLength; ++i) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        i = 0;
        int result = Integer.MAX_VALUE;
        while(i + 2 < numsLength) {
            if(arr[i][0] != arr[i + 1][0] || arr[i][0] != arr[i + 2][0]) {
                i += 1;
                continue;
            }
            result = Math.min(result, getDistance(arr, i));
            i += 1;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int getDistance(int[][] arr, int i) {
        return Math.abs(arr[i][1] - arr[i + 1][1])
            + Math.abs(arr[i + 1][1] - arr[i + 2][1])
            + Math.abs(arr[i + 2][1] - arr[i][1]);
    }
}
