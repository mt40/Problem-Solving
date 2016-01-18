package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CLONE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int n = in.i(), m = in.i();
            if(n == 0) return;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                String s = in.s();
                if (map.containsKey(s)) map.put(s, map.get(s) + 1);
                else map.put(s, 1);
            }

            int[] f = new int[n + 1];
            for (int i : map.values())
                f[i]++;

            for (int i = 0; i < n; ++i)
                out.println(f[i + 1]);
        }
    }
}