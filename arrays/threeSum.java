package arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class threeSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> result = findThreeSum(arr, n);
        for(int i = 0; i< result.size(); ++i) {
            for(int j = 0; j< result.get(0).size(); ++j) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    static ArrayList<ArrayList<Integer>> findThreeSum(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            int j = i+1, k = n-1;
            if(i>0 && arr[i] == arr[i-1])
                continue;
            while(j<k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum > 0) {
                    k--;
                }
                else if(sum < 0) {
                    j++;
                }   
                else {
                    ArrayList<Integer> temp  = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    result.add(temp);
                    j++;
                    k--;
                    while(j<k && arr[j] == arr[j-1])
                        j++;
                    while(j<k && arr[k] == arr[k+1])
                        k--;
                }
            } 
        }
        return result;
    }
}
