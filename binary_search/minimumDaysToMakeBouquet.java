package binary_search;

import java.util.Scanner;

public class minimumDaysToMakeBouquet {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(Integer i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        Integer m = sc.nextInt();
        Integer k = sc.nextInt();
        System.out.println(findMinimumDays(arr, n, m, k));
        sc.close();
    }

    static Integer findMinimumDays(Integer arr[], Integer n, Integer m, Integer k) {
        Integer maxDays = findMaxDays(arr, n);
        Integer minDays = findMinDays(arr, n);
        Integer low = minDays, high = maxDays;
        while(low <= high) {
            Integer mid = low + (high - low)/2;
            boolean isPossible = isPossible(arr, n, m, k, mid);
            if(isPossible) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        if(low > maxDays) {
            return -1;
        }
        return low;
    }

    static boolean isPossible(Integer arr[], Integer n, Integer m, Integer k, Integer mid) {
        Integer count = 0, sum = 0;
        for(Integer i = 0; i<n; ++i) {
            if(mid >= arr[i]) {
                sum += 1;
            }
            else {
                sum = 0;
            }

            if(sum == k) {
                sum = 0;
                count += 1;
            }
        }
        if(count >= m) {
            return true;
        }
        return false;
    }

    static Integer findMaxDays(Integer arr[], Integer n) {
        Integer max = Integer.MIN_VALUE;
        for(Integer i = 0;i<n;i++) {
            max = Integer.max(max, arr[i]);
        }
        return max;
    }

    static Integer findMinDays(Integer arr[], Integer n) {
        Integer min = Integer.MAX_VALUE;
        for(Integer i = 0;i<n;i++) {
            min = Integer.min(min, arr[i]);
        }
        return min;
    }
}
