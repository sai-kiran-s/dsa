package priority_queue;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;


public class gasStations {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i< n; ++i) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findNumberGasStationPlaced(arr, n, k));
        sc.close();
    }

    static int findNumberGasStationPlaced(int[] arr, int n, int k) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(
            (list1, list2) -> Integer.compare(list2.getFirst(), list1.getFirst()) == 0
                ? Integer.compare(list2.get(1), list1.get(1))
                : Integer.compare(list2.getFirst(), list1.getFirst())
                );
        int[] gaps = new int[n-1];
        for(int i=0; i<n-1; ++i) {
            ArrayList<Integer> arr1 = new ArrayList<>();
            arr1.add(arr[i+1]-arr[i]);
            arr1.add(i);
            pq.add(arr1);
        }
        for(int i = 0; i<k; ++i) {
            ArrayList<Integer> topFloat = pq.poll();
            gaps[topFloat.get(1)] += 1;
            int gap = (arr[topFloat.get(1)+1] - arr[topFloat.get(1)])/(gaps[topFloat.get(1)] + 1);
            ArrayList<Integer> arr1 = new ArrayList<>();
            arr1.add(gap);
            arr1.add(topFloat.get(1));
            pq.add(arr1);
        } 
        return pq.peek().get(0);
    }
}
