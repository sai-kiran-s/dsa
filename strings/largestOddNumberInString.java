package strings;

import java.util.Scanner;

public class largestOddNumberInString {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(largestOddNumber(s));
        sc.close();
    }

    public static String largestOddNumber(String num) {
        int size = num.length();
        int i = 0;
        for(i = size-1; i>=0; --i) {
            if(num.charAt(i) % 2 != 0) {
                break;
            }
        }
        int endIndex = -1;
        if(i == -1) {
            return "";
        }
        else {
            endIndex = i;
        }
        for(i = 0; i <= endIndex; ++i) {
            if(num.charAt(i) != '0') {
                break;
            }
        }
        int startIndex = i;
        return num.substring(startIndex, endIndex + 1);
    }
}
