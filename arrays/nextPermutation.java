package arrays;

import java.util.Scanner;

public class nextPermutation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(Integer i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer[] nextPermutation = findNextPermutation(arr, n);
        for(Integer i=0; i<n; ++i) {
            System.out.print(nextPermutation[i] + " ");
        }
        sc.close();
    }

    static Integer[] findNextPermutation(Integer[] arr, Integer n) {
        Integer j = -1;
        for(Integer i=n-2; i>=0; --i) {
            if(arr[i] < arr[i+1]) {
                j = i;
                break;
            }
        }
        if(j == -1) {
            return reverse(arr, 0, n-1);
        }
        for(Integer i=n-1; i>j; --i) {
            if(arr[i] > arr[j]) {
                swap(arr, i, j);
                break;
            }
        }
        return reverse(arr, j+1, n-1);
    }

    static Integer[] reverse(Integer[] arr, Integer start, Integer end) {
        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        return arr;
    }

    static void swap(Integer[] arr, Integer index1, Integer index2) {
        Integer temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
