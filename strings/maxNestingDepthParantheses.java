package strings;

import java.util.Scanner;

public class maxNestingDepthParantheses {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(maxDepth(s));
        sc.close();
    }

    static int maxDepth(String s) {
        int count = 0, maxCount = Integer.MIN_VALUE;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                count++;
            }
            else if(c == ')') {
                count--;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

}
