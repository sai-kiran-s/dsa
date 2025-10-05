package arrays;

import java.util.Scanner;
import java.util.HashMap;

public class countOfSubarraysWithXorK {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findCountOfSubarraysWithXorK(arr, n, k));
        sc.close();
    }

    static int findCountOfSubarraysWithXorK(int[] arr, int n, int k) {
        int xor = 0, count = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0,1);
        for(int i = 0; i < n; ++i) {
            xor ^= arr[i];
            int x = xor ^ k;
            Integer xCount = hashmap.get(x);
            if(xCount != null) {
                count += xCount;
            }
            Integer xorCount = hashmap.get(xor);
            if(xorCount != null) {
                hashmap.put(xor, xorCount+1);
            }
            else {
                hashmap.put(xor, 1);
            }
        }
        return count;
    }
}
