package twodarrays.binary_search;

import java.util.Scanner;

public class findElementIn2DArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                arr[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        System.out.println(searchMatrix(arr, target));
        sc.close();
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0, high = rows*cols - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int rowNumber = mid / cols;
            int colNumber = mid % cols;
            if(matrix[rowNumber][colNumber] == target) {
                return true;
            }
            else if(matrix[rowNumber][colNumber] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
}
