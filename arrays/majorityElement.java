package arrays;

import java.util.Scanner;

public class majorityElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(Integer i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        Long majorityElement = findMajorityElement(arr, n);
        System.out.println(majorityElement);
        sc.close();
    }

    static Long findMajorityElement(Integer arr[], Integer n) {
        Integer candidateElement = -1, votes = 0;
        for(Integer i=0; i<n; ++i) {
            if(votes == 0) {
                votes = 1;
                candidateElement = arr[i];
            }
            else if(candidateElement == arr[i]) {
                votes++;
            }
            else if(candidateElement != arr[i]) {
                votes--;
            }
        }
        Integer count = 0;
        for(Integer i = 0; i<n; ++i) {
            if(arr[i] == candidateElement) {
                count++;
            }
        }
        if(count > n/2) {
            return 1L;
        }
        else {
            return Long.MAX_VALUE;
        }
    }
}
