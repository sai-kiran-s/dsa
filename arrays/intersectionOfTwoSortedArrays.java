package arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class intersectionOfTwoSortedArrays {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
        for(int i=0; i<n1; ++i) {
            arr1[i] = sc.nextInt();
        }
        for(int i =0; i<n2; ++i) {
            arr2[i] = sc.nextInt();
        }
        ArrayList<Integer> intersectionList = getIntersectionOfTwoSortedArrays(arr1, arr2, n1, n2);
        for(Integer i: intersectionList) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    static ArrayList<Integer> getIntersectionOfTwoSortedArrays(int arr1[], int arr2[], int n1, int n2) {
        ArrayList<Integer> intersectionList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<n1 && j<n2) {
            if(arr1[i] < arr2[j]) {
                i++;
            }
            else if(arr2[j] < arr1[i]) {
                j++;
            }
            else {
                intersectionList.add(arr1[i]);
                i++;
                j++;
            }
        }
        return intersectionList;
    }
}
