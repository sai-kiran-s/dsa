package arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class majorityElement2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = findMajorityElement(arr, n);
        for(int i=0; i<ans.size(); ++i)
            System.out.print(ans.get(i) + " ");
        sc.close();
    }

    static ArrayList<Integer> findMajorityElement(int[] arr, int n) {
        int cnt1 = 0, cnt2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        for(int i=0; i<n; ++i) {
            if(cnt1 == 0 && arr[i]!=ele2) {
                cnt1 = 1;
                ele1 = arr[i];
            }
            else if(cnt2 == 0 && arr[i]!=ele2) {
                cnt2 = 0;
                ele2 = arr[i];
            }
            else if(arr[i] == ele1) {
                cnt1++;
            }
            else if(arr[i] == ele2) {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        cnt1=0;
        cnt2=0;
        for(int i=0; i<n; ++i) {
            if(arr[i] == ele1)
                cnt1++;
            else if(arr[i] == ele2)
                cnt2++;
        }
        int mini = n/3;
        if(cnt1 > mini)
            ans.add(ele1);
        if(cnt2 > mini)
            ans.add(ele2);
        return ans;

    }
}
