package binary_search;

import java.util.Scanner;

public class kokoEatingBananas {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0;i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer deadlineHours = sc.nextInt();
        System.out.println(findMinimumBananasToEat(arr, n, deadlineHours));
        sc.close();
    }

    static Integer findMinimumBananasToEat(Integer arr[], Integer n, Integer deadlineHours) {
        Integer max = findMaximumBananas(arr, n);
        Integer low = 0, high = max;
        while(low <= high) {
            Integer mid = low + (high - low);
            Integer sumOfHours = findTotalHoursWithMid(arr, mid, n);
            if(sumOfHours <= deadlineHours) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    static Integer findMaximumBananas(Integer arr[], Integer n) {
        Integer max = Integer.MIN_VALUE;
        for(Integer i = 0; i<n; ++i) {
            max = Integer.max(max, arr[i]);
        }
        return max;
    }

    static Integer findTotalHoursWithMid(Integer arr[], Integer mid, Integer n) {
        Integer sum = 0;
        for(Integer i = 0; i<n; ++i) {
            sum += (int) Math.ceil((double) arr[i] / mid);
        }
        return sum;
    }
}
