package arrays;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class twoSumHashing {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer target = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> result = getTwoSum(arr, n, target);
        System.out.println(result);
        sc.close();
    }

    static ArrayList<Integer> getTwoSum(Integer arr[], int n, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        Integer rem = 0;
        Integer remIndex = 0;
        for(int i=0; i<n; ++i) {
            rem = target - arr[i];
            remIndex = indexMap.get(rem);
            if(remIndex != null) {
                result.add(i);
                result.add(remIndex);
                return result;
            }
            indexMap.put(arr[i], i);
        }
        return result;
    }
}
