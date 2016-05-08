package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GOSSIPER {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int n = in.i(), m = in.i();
            if(n == 0) return;

            Map<String, Integer> map = new HashMap<>(n);
            for(int i = 0; i < n; ++i) {
                String name = in.s();
                map.put(name, i);
            }

            List<Pair> meetings = new ArrayList<>(m);
            for(int i = 0; i < m; ++i) {
                String a = in.s(), b = in.s();
                meetings.add(new Pair(map.get(a), map.get(b)));
            }

            boolean ans = calc(meetings, n);
            out.println(ans ? "YES" : "NO");
        }
    }

    boolean calc(List<Pair> meetings, int n) {
        BitSet []sets = new BitSet[n];
        for(int i = 0; i < n; ++i) {
            sets[i] = new BitSet(n);
            sets[i].set(i);
        }

        for(Pair p : meetings) {
            int a = p.first, b = p.second;
            unite(sets[a], sets[b]);
        }

        for(BitSet bs : sets)
            if(bs.cardinality() != n)
                return false;
        return true;
    }

    void unite(BitSet a, BitSet b) {
        a.or(b);
        b.or(a);
    }

    class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}