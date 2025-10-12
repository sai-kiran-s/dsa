package arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class countInversionsArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer count = mergeSort(arr, 0, n-1);
        System.out.println(count);
        sc.close();
    }

    static Integer mergeSort(final Integer[] arr, final Integer low, final Integer high) {
        Integer count = 0;
        if(low >= high) {
            return count;
        }
        Integer mid = (low+high)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    static Integer merge(Integer arr[], Integer low, Integer mid, final Integer high) {
        Integer count = 0;
        Integer left = low, right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right<= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left +=1 ;
            }
            else {
                count += mid-left+1;
                temp.add(arr[right]);
                right += 1;
            }
        }
        while(left <= mid) {
            temp.add(arr[left]);
            left+=1;
        }
        while(right <= high) {
            temp.add(arr[right]);
            right+=1;
        }
        for(int i=low; i<=high; ++i) {
            arr[i] = temp.get(i-low);
        }
        return count;
    }
    
}
