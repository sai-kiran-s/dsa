package binary_search;

import java.util.Scanner;

public class floorOfAnElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer x = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer floor = findFloor(arr, n, x);
        System.out.println(floor);
        sc.close();
    }

    static Integer findFloor(Integer arr[], Integer n, Integer x) {
        Integer floor = -1;
        Integer low = 0, high = n-1;
        while(low <= high) {
            Integer mid = low + (high - low)/2;
            if(arr[mid] <= x) {
                floor = arr[mid];
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return floor;
    }
}
