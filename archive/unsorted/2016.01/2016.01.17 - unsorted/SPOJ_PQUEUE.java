package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PQUEUE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), x = in.i();
        int []a = in.arr(n);

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<Pair> d = new LinkedList<>();
        for(int i = 0; i < n; ++i) {
            heap.add(a[i]);
            d.add(new Pair(a[i], i));
        }
        int ans = 0;
        while(true) {
            Pair p = d.peek();
            if(p.v < heap.peek()) d.add(d.poll());
            else {
                d.poll();
                heap.poll();
                ans++;
                if(p.id == x) break;
            }
        }
        out.println(ans);
    }

    class Pair {
        int id, v;

        public Pair(int v, int id) {
            this.id = id;
            this.v = v;
        }
    }
}