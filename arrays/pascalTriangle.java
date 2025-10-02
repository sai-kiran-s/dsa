package arrays;

import java.util.Scanner;

public class pascalTriangle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        generatePascalTriangle(r);
        sc.close();
    }

    static void generatePascalTriangle(int r) {
        for(int i=1; i<=r; ++i) {
            generatePascalRow(i);
        }
    }

    static void generatePascalRow(int r) {
        int ans = 1;
        System.out.print(ans + " ");
        for(int i=1; i<r; ++i) {
            ans *= r-i;
            ans /= i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }
}
