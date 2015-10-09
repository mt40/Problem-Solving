package workspace;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;

public class AlmostSortedArray {
    /**
     * Sort an array whose elements are at most k position away
     * from their correct position.
     * Complexity O(nlogk)
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k + 1);
        int cur = 0;
        for(int i = 0; i < n; ++i) {
            heap.add(a[i]);
            if(heap.size() == k + 1) {
                a[cur++] = heap.poll();
            }
        }
        while(heap.size() > 0) {
            a[cur++] = heap.poll();
        }

        for(int x : a) {
            out.print(x + " ");
        }
        out.println();
    }
}
