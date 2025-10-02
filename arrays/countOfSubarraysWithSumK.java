package arrays;

import java.util.Scanner;
import java.util.HashMap;

public class countOfSubarraysWithSumK {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();
        int result = findCountOfSubarraysWithSumK(arr, n, k);
        System.out.print(result);
        sc.close();
    }

    static int findCountOfSubarraysWithSumK(int[] arr, int n, int k) {
        HashMap<Integer, Integer> prefixSumHashMap = new HashMap<>();
        prefixSumHashMap.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for(int i=0; i<n; ++i) {
            prefixSum += arr[i];
            Integer remove = prefixSum - k;
            Integer removeCount = prefixSumHashMap.get(remove);
            if(removeCount != null)
                count += prefixSumHashMap.get(remove);
            Integer prevCount = prefixSumHashMap.get(prefixSum);
            if(prevCount != null)
                prefixSumHashMap.put(prefixSum, prevCount+1);
            else
                prefixSumHashMap.put(prefixSum, 1);
        }
        return count;
    }
}
