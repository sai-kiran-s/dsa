package arrays;

import java.util.Scanner;

public class maximizeExpressionOfThree {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        for(int num : nums) {
            min = Math.min(min, num);
            if(max1 <= num) {
                max2 = max1;
                max1 = num;
            }
            else if(max2 < num && num != max1) {
                max2 = num;
            }
        }
        System.out.println(max1 + max2 - min);
        sc.close();

    }
    
}
