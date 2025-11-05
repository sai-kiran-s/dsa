package twodarrays.binary_search;
import java.util.Scanner;

public class findMedianOfRowWiseSorted2DArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(findMedian(arr));
        sc.close();
    }

    static int findMedian(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < rows; ++i) {
            low = Math.min(low, arr[i][0]);
            high = Math.max(high, arr[i][cols-1]);
        }
        int minimumCount = (rows * cols)/2;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int LTEMid = lessThanEqualToMid(arr, mid, rows, cols);
            if(LTEMid > minimumCount) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int lessThanEqualToMid(int[][] arr, int mid, int rows, int cols) {
        int count = 0;
        for(int  i = 0; i < rows; ++i) {
            int low = 0, high = cols - 1;
            while(low <= high) {
                int mid1 = low + (high - low) / 2;
                if(arr[i][mid1] <= mid) {
                    low = mid1 + 1;
                }
                else {
                    high = mid1 - 1;
                }
            }
            count += low;
        }
        return count;
    }
}
