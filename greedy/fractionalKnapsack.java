package greedy;

import java.util.Scanner;
import java.util.Arrays;

class Triple {
    int val;
    int weight;
    float profitPerWeight;

    Triple(int val, int weight, float profitPerWeight) {
        this.val = val;
        this.weight = weight;
        this.profitPerWeight = profitPerWeight;
    }

    @Override
    public String toString() {
        return "val = " + val + " weight =  " + weight + " profitPerWeight = " + profitPerWeight;
    }
}

public class fractionalKnapsack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vals = new int[n];
        int[] weights = new int[n];
        int i = 0;
        for(i = 0; i < n; ++i) {
            vals[i] = sc.nextInt();
        }
        for(i = 0; i < n; ++i) {
            weights[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();
        Triple[] triples = new Triple[n];
        for(i = 0; i < n; ++i) {
            triples[i] = new Triple(vals[i], weights[i], vals[i] / weights[i]);
        }
        Arrays.sort(triples, (a, b) -> Float.compare(b.profitPerWeight, a.profitPerWeight));
        i = 0;
        int result = 0;
        while(capacity > 0 && i < n) {
            if(capacity >= triples[i].weight){
                result += triples[i].val;
                capacity -= triples[i].weight;
            }
            else {
                result += triples[i].profitPerWeight * capacity;
                capacity = 0;
            }
            i+=1;
        }
        System.out.println(result);
        sc.close();
    }
}
