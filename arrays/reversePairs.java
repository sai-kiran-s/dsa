package arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class reversePairs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer reversePairs = mergeSort(arr, 0, n-1);
        for(Integer i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(reversePairs);
        sc.close();
    }

    static Integer mergeSort(Integer arr[], Integer low, Integer high) {
        Integer reversePairs = 0;
        if(low >= high) {
            return reversePairs;
        }
        Integer mid = (low+high)/2;
        reversePairs += mergeSort(arr, low, mid);
        reversePairs += mergeSort(arr, mid+1, high);
        reversePairs += getReversePairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return reversePairs;
    }

    static Integer getReversePairs(Integer arr[], Integer low, Integer mid, Integer high) {
        Integer reversePairs = 0;
        Integer right = mid+1;
        for(Integer left = low; left<=mid ;++left) {
            while(right<=high && arr[left] > 2*arr[right]) {
                right++;
            }
            reversePairs += (right - (mid+1));
        }
        return reversePairs;
    }

    static void merge(Integer arr[], Integer low, Integer mid, Integer high) {
        ArrayList<Integer> temp = new ArrayList<>();
        Integer left = low;
        Integer right = mid+1;
        while(left <= mid && right<=high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left+=1;
            }
            else {
                temp.add(arr[right]);
                right+=1;
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

        for(Integer i = low; i<=high ;++i) {
            arr[i] = temp.get(i-low);
        }
    }
}
