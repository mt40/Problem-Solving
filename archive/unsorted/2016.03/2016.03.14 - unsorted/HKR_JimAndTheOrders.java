package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.TreeMap;

import helperClasses.FastScanner;
import helperClasses.Util;

public class HKR_JimAndTheOrders {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        TreeMap<Pair, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; ++i)
            map.put(new Pair(in.i() + in.i(), i + 1), 1);

        for(Pair keys : map.keySet()) {
            out.print(keys.idx + " ");
        }
        out.println();
    }

    class Pair implements Comparable<Pair> {
        int time, idx;

        public Pair(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            int t = Integer.compare(time, o.time);
            return (t != 0) ? t : Integer.compare(idx, o.idx);
        }
    }
}