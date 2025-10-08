package arrays;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class mergeOverlappingSubarrays {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = 2;
        int arr[][] = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<2; ++j) {
                arr[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(arr, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<m; ++i) {
            int lastIndex = ans.size() - 1;
            if(ans.isEmpty() || ans.get(lastIndex).get(1) < arr[i][0]) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr[i][0]);
                temp.add(arr[i][1]);
                ans.add(temp);
            }
            else {
                lastIndex = ans.size() - 1;
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(ans.get(lastIndex).get(0));
                temp.add(Math.max(ans.get(lastIndex).get(1), arr[i][1]));
                ans.set(lastIndex, temp);
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
