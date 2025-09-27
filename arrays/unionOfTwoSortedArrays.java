package arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class unionOfTwoSortedArrays {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];
        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        for(int i=0; i<n1 ; ++i) {
            arr1[i] = sc.nextInt();
        }
        for(int i=0; i<n2 ; ++i) {
            arr2[i] = sc.nextInt();
        }
        ArrayList<Integer> unionList = getUnionOfTwoSortedArrays(arr1, arr2, n1, n2);
        for(Integer i: unionList) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    static ArrayList<Integer> getUnionOfTwoSortedArrays(int arr1[], int arr2[], int n1, int n2) {
        ArrayList<Integer> unionList = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n1 && j < n2) {
            if(arr1[i] < arr2[j]) {
                if(k == 0 || unionList.get(k-1) != arr1[i]) {
                    unionList.add(arr1[i]);
                    k++;
                }
                i++;
            }
            else {
                if(k == 0 || unionList.get(k-1) != arr2[j]) {
                    unionList.add(arr2[j]);
                    k++;
                }
                j++;
            }
        }

        while(i < n1) {
            if(k == 0 || unionList.get(k-1) != arr1[i]) {
                unionList.add(arr1[i]);
                k++;
            }
            i++;
        }

        while(j < n2) {
            if(k == 0 || unionList.get(k-1) != arr2[j]) {
                unionList.add(arr2[j]);
                k++;
            }
            j++;
        }
        return unionList;
    }
}
