package arrays;

import java.util.Scanner;

public class pascalTriangleFindRthCthElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long r = sc.nextInt();
        long c = sc.nextInt();
        r -= 1;
        c -= 1;
        long result = 1;
        for(int i=0; i<c; ++i) {
            result *= r-i;
            result /= i+1;
        }
        System.out.print(result);
        sc.close();
    }
}
