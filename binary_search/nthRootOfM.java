package binary_search;

import java.util.Scanner;

public class nthRootOfM {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer m = sc.nextInt();
        Integer n = sc.nextInt();
        System.out.println(findNthRootOfM(m,n));
        sc.close();
    }

    static Integer findNthRootOfM(Integer m, Integer n) {
        Integer low = 1, high = m;
        while(low <= high) {
            Integer mid = low + (high - low)/2;
            Integer nTimesMid  = findNTimesMid(mid, n);
            if(nTimesMid == m) {
                return mid;
            }
            else if(nTimesMid > m) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static Integer findNTimesMid(Integer mid, Integer n) {
        Integer ans = 1;
        while(n > 0) {
            if(n%2 == 1) {
                ans = ans * mid;
                n = n - 1;
            }
            else if(n%2 == 0) {
                mid = mid * mid;
                n = n/2;
            }
        }
        return ans;
    }
}
