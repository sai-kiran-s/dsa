package strings;
import java.util.Scanner;

public class reverseWordsInAString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseWords(s));
        sc.close();
    }

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                if(word.toString().length() != 0) {
                    if(result.toString().length() != 0) {
                        word.append(c);
                    }
                    result.insert(0, word);
                    word.setLength(0);
                }
            }
            else {
                word.append(c);
            }
        }
        if(word.toString().length() != 0)
        {
            if(result.toString().length() != 0) {
                word.append(' ');
            }
            result.insert(0, word);
        }
        return result.toString();
    }
}
