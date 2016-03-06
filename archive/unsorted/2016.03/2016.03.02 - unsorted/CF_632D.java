package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_632D {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        int[] a = in.arr(n);

        int []sieve = new int[m + 1];
        sieve[1] = 0;

        HashMap<Integer, Integer> f = new HashMap<>();
        for(int ai : a) {
            if(f.containsKey(ai))
                f.put(ai, f.get(ai) + 1);
            else f.put(ai, 1);
        }

        HashSet<Integer> vst = new HashSet<>();
        Pair max = new Pair(1, 0);
        for (int i = 0; i < n; ++i) {
            int x = a[i];
            if(vst.contains(x)) continue;
            vst.add(x);
            while (x <= m) {
                sieve[x] += f.get(a[i]);
                updateMax(sieve[x], x, max);
                x += a[i];
            }
        }

        out.printf("%d %d\n", max.idx, max.cnt);
        StringBuilder sb = new StringBuilder();
        // recover max
        for (int i = 0; i < n; ++i) {
            int x = a[i];
            while (x <= m) {
                if(x == max.idx) {
                    sb.append(i + 1).append(" ");
                    break;
                }
                x += a[i];
            }
        }
        out.println(sb.toString());
    }

    void updateMax(int cnt, int idx, Pair max) {
        if(cnt > max.cnt) {
            max.cnt = cnt;
            max.idx = idx;
        }
    }

    class Pair {
        int idx, cnt;

        public Pair(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}