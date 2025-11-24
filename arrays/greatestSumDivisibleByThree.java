package arrays;

import java.util.Scanner;

public class greatestSumDivisibleByThree {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSumDivThree(arr));
        sc.close();
    }

    static int maxSumDivThree(int[] arr) {
        int minEleRem11 = Integer.MAX_VALUE, minEleRem21 = Integer.MAX_VALUE, sum = 0;
        int minEleRem12 = Integer.MAX_VALUE, minEleRem22 = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if(arr[i] % 3 == 1) {
                if(arr[i] < minEleRem11) {
                    minEleRem12 = minEleRem11;
                    minEleRem11 = arr[i];
                }
                else if(arr[i] < minEleRem12)
                    minEleRem12 = arr[i];
            }
            else if(arr[i] % 3 == 2) {
                if(arr[i] < minEleRem21) {
                    minEleRem22 = minEleRem21;
                    minEleRem21 = arr[i];
                }
                else if(arr[i] < minEleRem22)
                    minEleRem22 = arr[i];
            }
        }
        if(sum % 3 == 0) {
            return sum;
        }
        else {
            if(sum % 3 == 1) {
                if(minEleRem21 != Integer.MAX_VALUE && minEleRem22 != Integer.MAX_VALUE && minEleRem11 != Integer.MAX_VALUE) {
                        if(minEleRem21 + minEleRem22 < minEleRem11) {
                            sum = sum - (minEleRem21 + minEleRem22);
                        }
                        else {
                            sum = sum - minEleRem11;
                        }

                } else if(minEleRem11 != Integer.MAX_VALUE) {
                    sum = sum - minEleRem11;
                }
                else if(minEleRem21 != Integer.MAX_VALUE && minEleRem22 != Integer.MAX_VALUE){
                    sum = sum - (minEleRem21 + minEleRem22);
                }
                else {
                    sum = 0;
                }
            }
            else if(sum % 3 == 2) {
                if(minEleRem11 != Integer.MAX_VALUE && minEleRem12 != Integer.MAX_VALUE && minEleRem21 != Integer.MAX_VALUE) {
                        if(minEleRem11 + minEleRem12 < minEleRem21) {
                            sum = sum - (minEleRem11 + minEleRem12);
                        }
                        else {
                            sum = sum - minEleRem21;
                        }

                }
                else if(minEleRem21 != Integer.MAX_VALUE) {
                    sum = sum - minEleRem21;
                }
                else if(minEleRem11 != Integer.MAX_VALUE && minEleRem12 != Integer.MAX_VALUE){
                    sum = sum - (minEleRem11 + minEleRem12);
                }
                else {
                    sum = 0;
                }
            }
            return sum;
        }
    }
}
