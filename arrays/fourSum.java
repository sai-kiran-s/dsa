package arrays;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class fourSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> fourSumElements = findFourSum(arr, n, target);
        for(ArrayList<Integer> ele: fourSumElements) {
            for(Integer ele1: ele) {
                System.out.print(ele1 + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    static ArrayList<ArrayList<Integer>> findFourSum(int[] arr, int n, int target) {
        ArrayList<ArrayList<Integer>> fourSumElements = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i<n; ++i) {
            if(i!=0 && arr[i] == arr[i-1])
                continue;
            for(int j=i+1; j<n; ++j) {
                if(j!=i+1 && arr[j] == arr[j-1])
                    continue;
                int k = j+1;
                int l = n-1;
                while(k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum == target) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        fourSumElements.add(temp);
                        k++;
                        l--;
                    }
                    else if(sum < target) {
                        k++;
                    }
                    else {
                        l--;
                    }
                    while(k<l && arr[k] == arr[k-1])
                        k++;
                    while(k<l && arr[l] == arr[l+1])
                        l--;
                }
            }
        }
        return fourSumElements;
    }
}
