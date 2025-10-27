package binary_search;

import java.util.Scanner;

public class allocateBooksStudents {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findMinMaxAllocationPossible(arr, n, k));
        sc.close();
    }

    static int findMinMaxAllocationPossible(int[] arr, int n, int k) {
        int low = maxPages(arr, n);
        int high = sumPages(arr, n);
        System.out.println("low: " + low + " high: " + high);
        while(low <= high) {
            System.out.println("low: " + low + " high: " + high);
            int mid = low + (high - low)/2;
            System.out.println("mid: " + mid);
            int students = findStudentsWithMidAllocation(arr, mid);
            System.out.println("students: " + students);
            if(students > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;

    }

    static int maxPages(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for(int i: arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    static int sumPages(int arr[], int n) {
        int sum = 0;
        for(int i: arr) {
            sum += i;
        }
        return sum;
    }

    static int findStudentsWithMidAllocation(int arr[], int mid) {
        int countStudents = 1, pagesAllocated = 0;
        for(int i: arr) {
            if(pagesAllocated + i <= mid) {
                pagesAllocated += i;
            }
            else {
                countStudents += 1;
                pagesAllocated = i;
            }
        }
        return countStudents;
    }
}
