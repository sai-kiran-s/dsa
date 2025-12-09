package greedy;
import java.util.Scanner;

public class coinChange {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int[] denominations = new int[] {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int i = 8, count = 0;
        while(v > 0) {
            while(v < denominations[i]) {
                i--;
            }
            count += v / denominations[i];
            v %= denominations[i];
        }
        System.out.println(count);
        sc.close();
    } 
}
