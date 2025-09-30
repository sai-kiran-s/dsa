package arrays;

import java.util.Scanner;
import java.util.HashSet;

public class longestConsecutiveSubsequence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        HashSet<Integer> uniqueElements = new HashSet<>();
        for(Integer i=0; i<n; ++i) {
            uniqueElements.add(arr[i]);
        }
        Integer longest = 1;
        for(Integer i: uniqueElements) {
            if(!uniqueElements.contains(i-1)) {
                Integer cnt = 1;
                Integer x = i;
                while(uniqueElements.contains(x+1)) {
                    cnt += 1;
                    x += 1;
                }
                longest = Math.max(cnt, longest);
            }
        }
        System.out.print(longest);
        sc.close();
    }
}
