package arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class leadersInTheArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> leaders = findLeaders(arr, n);
        for(Integer i:leaders) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    static ArrayList<Integer> findLeaders(Integer[] arr, Integer n) {
        ArrayList<Integer> leaders = new ArrayList<>();
        Integer maxi = Integer.MIN_VALUE;
        for(Integer i=n-1; i>=0; --i) {
            if(arr[i] > maxi) {
                maxi = arr[i];
                leaders.add(arr[i]);
            }
        }
        return leaders;
    }
}
