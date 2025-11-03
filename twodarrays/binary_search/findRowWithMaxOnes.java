package twodarrays.binary_search;

import java.util.Scanner;

public class findRowWithMaxOnes {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i<n; ++i) {
            for(int j = 0; j<m; ++j) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = -1, maxCount = Integer.MIN_VALUE;
        for(int i = 0; i<n; ++i) {
            int low = 0, high = m - 1;
            while(low <= high) {
                int mid = low + (high - low)/2;
                if(arr[i][mid] == 1) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            if(low > n-1) {
                ans = Math.max(ans, -1);
            }
            else {
                int count = m - low;
                if(count > maxCount) {
                    maxCount = count;
                    ans = i;
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
