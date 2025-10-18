package binary_search;

import java.util.Scanner;

public class sqrtNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer x = sc.nextInt();
        System.out.println(findSqrt(x));
        sc.close();
    }

    static Integer findSqrt(Integer x) {
        Integer low = 1, high = x;
        while(low <= high) {
            Integer mid = low + (high - low)/2;
            if(mid * mid <= x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return high;
    }
}
