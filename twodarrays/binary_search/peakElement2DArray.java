package twodarrays.binary_search;

import java.util.Scanner;

public class peakElement2DArray {
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
        int ans[] = findPeakGrid(arr);
        System.out.println(ans[0] + "," + ans[1]);
        sc.close();
    }

    public static int[] findPeakGrid(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int low = 0, high = cols - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int maxRow = findMaxPos(arr, mid, rows);
            int left = -1, right = -1;
            if(mid != 0) left = arr[maxRow][mid - 1];
            if(mid != cols-1) right = arr[maxRow][mid + 1];
            if(arr[maxRow][mid] > left && arr[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            }
            if(arr[maxRow][mid] < left) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static int findMaxPos(int[][] arr, int mid, int rows) {
        int maxEle = Integer.MIN_VALUE;
        int maxRow = -1;
        for(int i = 0; i < rows; ++i) {
            if(maxEle < arr[i][mid]) {
                maxEle = arr[i][mid];
                maxRow = i;
            }
        }
        return maxRow;
    }
}
