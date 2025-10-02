package arrays;

import java.util.Scanner;

public class pascalTrianglePrintRthRow {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int ans = 1;
        System.out.print(ans + " ");
        for(int i=1; i<r; ++i)
        {
            ans *= (r-i);
            ans /= i;
            System.out.print(ans + " ");
        }
        sc.close();
    }
}
