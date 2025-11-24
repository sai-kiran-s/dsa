package arrays;

import java.util.Scanner;
import java.util.Arrays;

public class dungeonEquilibrium {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int count = 0, ele = arr[0], result = 0;
            for(int i = 0; i < n; ++i) {
                if(arr[i] == ele) {
                    count++;
                    continue;
                }
                if(count < ele) {
                    result += count;
                }
                else if(count > ele) {
                    result += count - ele;
                }
                ele = arr[i];
                count = 1;
            }
            if(count < ele) {
                result += count;
            }
            else if(count > ele) {
                result += count - ele;
            }
            System.out.println(result);
            t--;
        }
        sc.close();
    }
}