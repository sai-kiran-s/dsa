package strings;

import java.util.Scanner;

public class romanNumeralToInteger {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getInteger(s));
        sc.close();
    }

    static int getInteger(String s) {
        int result = 0, sLength = s.length();
        for(int i = 0; i < sLength; ++i) {
            char c = s.charAt(i);
            Character next = null;
            if(i != sLength - 1) {
                next = s.charAt(i + 1);
            }
            switch(c) {
                case 'I':   if(next != null) {
                                if(next.equals('X')) {
                                    result += 9;
                                    i += 1;
                                }
                                else if(next.equals('V')) {
                                    result += 4;
                                    i += 1;
                                }
                                else {
                                    result += 1;
                                }
                            }
                            else {
                                result += 1;
                            }
                            break;
                case 'V':   result += 5;
                            break;
                case 'X':   if(next != null) {
                                if(next.equals('L')) {
                                    result += 40;
                                    i += 1;
                                }
                                else if(next.equals('C')) {
                                    result += 90;
                                    i += 1;
                                }
                                else {
                                    result += 10;
                                }
                            }
                            else {
                                result += 10;
                            }
                            break;
                case 'L':   result += 50;
                            break;
                case 'C':   if(next != null) {
                                if(next.equals('D')) {
                                    result += 400;
                                    i += 1;
                                }
                                else if(next.equals('M')) {
                                    result += 900;
                                    i += 1;
                                }
                                else {
                                    result += 100;
                                }
                            }
                            else {
                                result += 100;
                            }
                            break;
                case 'D':   if(next != null) {
                                if(next.equals('D')) {
                                    result += 400;
                                    i += 1;
                                }
                                else if(next.equals('M')) {
                                    result += 900;
                                    i += 1;
                                }
                                else {
                                    result += 500;
                                }
                            }
                            else {
                                result += 500;
                            }
                            break;
                case 'M':   result += 1000;
                            break;
                
            }
        }
        return result;
    }
}
