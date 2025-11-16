package strings;

import java.util.Scanner;

public class atoi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(myAtoi(s));
        sc.close();
    }

    static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        int sLength = s.length();
        int i = 0;
        Boolean isNegative = null;
        Boolean digitFound = false;
        while(i < sLength) {
            char c = s.charAt(i);
            if(c == ' ') {
                if(sb.toString().length() != 0 || digitFound) {
                    break;
                }
                i++;
                continue;
            }
            if(c == '0' && sb.toString().length() == 0) {
                digitFound = true;
                i++;
                continue;
            }
            if(c == '-' || c == '+' || (c - '0' >= 0 && c - '0' <= 9)) {
                if(c == '-') {
                    if(isNegative != null || digitFound == true || sb.toString().length() != 0) {
                        break;
                    }
                    isNegative = true;
                }
                else if(c == '+') {
                    if(isNegative != null || digitFound == true || sb.toString().length() != 0) {
                        break;
                    }
                    isNegative = false;
                }
                sb.append(c);
            }
            else {
                break;
            } 
            i++;
        }
        if(isNegative == null) {
            isNegative = false;
            sb.insert(0, '+');
        }
        long result = 0, multiplicand = 1;
        String validatedString = sb.toString();
        int sbLength = validatedString.length();
        i = sbLength - 1;
        while(i > 0) {
            char c = validatedString.charAt(i);
            if(multiplicand > Integer.MAX_VALUE) {
                multiplicand = Integer.MAX_VALUE;
            }
            if(c == '0') {
                i-=1;
                multiplicand *= 10;
                continue;
            }
            if(isNegative) {
                if(result == Integer.MIN_VALUE || result - (c - '0') * multiplicand <= Integer.MIN_VALUE) {
                    result = Integer.MIN_VALUE;
                    break;
                }
                else
                    result -= (c - '0') * multiplicand;
            }
            else{
                if(result == Integer.MAX_VALUE || result + (c - '0') * multiplicand >= Integer.MAX_VALUE) {
                    result = Integer.MAX_VALUE;
                    break;
                }
                else
                    result += (c - '0') * multiplicand;
            }
            System.out.println(result);
            multiplicand *= 10;
            i--;
        }
        return (int)result;
    }
}
