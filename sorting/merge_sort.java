package sorting;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class merge_sort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n-1);
        for(int i = 0; i<n; ++i) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    static void mergeSort(int arr[], int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    static void merge(int arr[], int low, int mid, int high) {
        System.out.println("low = " + low + " mid = " + mid + " high = "+ high);
        List<Integer> temp = new ArrayList<Integer>();
        int left = low;
        int right = mid+1;
        while(left<=mid && right<=high) {
            if(arr[left] < arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left < mid +1) {
            temp.add(arr[left]);
            left++;
        }
        while(right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for(int i=low; i<=high; ++i){
            arr[i] = temp.get(i-low);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}
