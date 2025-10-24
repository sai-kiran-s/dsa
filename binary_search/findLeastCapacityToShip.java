package binary_search;

import java.util.Scanner;

public class findLeastCapacityToShip {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        for(int i=0; i<n; ++i) {
            weights[i] = sc.nextInt();
        }
        int days = sc.nextInt();
        System.out.println(findCapacity(n, weights, days));
        sc.close();
    }

    static int findCapacity(int n, int[] weights, int days) {
        int[] extremes = findExtremes(weights, n);
        int low = extremes[0];
        int high = extremes[1];
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isCapacityPossible(mid, weights, days, n))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low >= extremes[0] ? low : -1;
    }

    static int[] findExtremes(int[] weights, int n) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int weight: weights) {
            sum += weight;
            max = Math.max(max, weight);
        }
        return new int[]{max, sum};
    }

    static boolean isCapacityPossible(int mid, int[] weights, int days, int n) {
        int sum = 0;
        int countDays = 0;
        for(int weight: weights) {
            if(sum + weight > mid) {
                sum = weight;
                countDays += 1;
            }
            else {
                sum += weight;
            }
        }
        countDays = sum>0 ? countDays+1 : countDays;
        return countDays <= days ? true : false;
    }
}
