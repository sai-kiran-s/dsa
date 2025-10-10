package arrays;

import java.util.Scanner;

public class findMissingAndRepeatingNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        long sum2 = 0;
        long sum1 = n*(n+1)/2;
        long sumSquare1 = (n*(n+1)*((2*n)+1))/6;
        long sumSquare2 = 0;
        for(int i = 0; i<n; ++i) {
            sum2 += arr[i];
            sumSquare2 += arr[i]*arr[i];
        }
        long val1 = sum1 - sum2;
        long val2 = sumSquare1 - sumSquare2;
        val2 = val2/val1;
        long x = (val1 + val2)/2;
        long y = x - val1;
        System.out.println(x + " " + y);
        sc.close();
    }
}
