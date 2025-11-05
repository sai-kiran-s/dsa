package strings;

import java.util.Scanner;

public class removeOutermostParentheses {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(removeOuterParentheses(s));
        sc.close();
    }

    static String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(count == 0 && c == '(') {
                count +=1;
                continue;
            }
            else if(count == 1 && c == ')') {
                count -= 1;
                continue;
            }
            else {
                if(c == '(') {
                    count += 1;
                }
                else {
                    count -= 1;
                }
                result.append(c);
            }
        }
        return result.toString();
    }
}
