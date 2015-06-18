package workspace;

import java.util.*;
import java.io.PrintWriter;

/**
 * Given a number k
 * For each index i in ARR, find min (ARR[i ... i - k + 1])
 */
public class SlidingWindow {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int []a = new int[n];

        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        //log_time(a, k);
        //System.out.println();
        //log_time2(a, k);
        //System.out.println();
        constant_time(a, k);
    }

    void log_time(int []arr, int k) {
        SortedSet<Integer> window = new TreeSet<Integer>();
        for(int i = 0; i < arr.length; ++i) {
            window.add(arr[i]);
            if(i - k >= 0)
                window.remove(arr[i - k]);
            System.out.print(window.first() + " ");
        }
    }

    /**
     * Slightly better than the first one
     */
    void log_time2(int []arr, int k) {
        // min heap
        PriorityQueue<Pair> window = new PriorityQueue<Pair>();
        for(int i = 0; i < arr.length; ++i) {
            window.add(new Pair(arr[i], i));
            while(window.peek().pos <= i - k) {
                window.poll();
            }
            System.out.print(window.peek().val + " ");
        }
    }

    /**
     * We remove the elements >= arr[i] because those elements
     * can never be the answer
     */
    void constant_time(int []arr, int k) {
        Deque<Pair> window = new ArrayDeque<Pair>();
        for(int i = 0; i < arr.length; ++i) {
            while(!window.isEmpty() && window.peekLast().val >= arr[i])
                window.pollLast();

            window.addLast(new Pair(arr[i], i));

            while(window.peekFirst().pos <= i - k)
                window.pollFirst();


            System.out.print(window.peek().val + " ");
            System.out.println(Arrays.toString(window.toArray()));
        }
    }

    /**
     * value and its position in an array
     */
    class Pair implements Comparable<Pair> {
        int val, pos;

        public Pair(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.val, o.val);
        }

        @Override
        public String toString() {
            return "{" + val + ":" + pos + "}";
        }
    }
}
