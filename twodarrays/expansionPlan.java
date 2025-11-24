package twodarrays;
import java.util.Scanner;

public class expansionPlan {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            int countOf8 = 0;
            for(char c : s.toCharArray()) {
                if(c == '8') {
                    countOf8++;
                }
            }
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            if(absX <= n && absY <= n && absX + absY <= n + countOf8) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
            t--;
        }
        sc.close();

    }
}
