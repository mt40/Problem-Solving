package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_660D {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []x = new int[n];
        int []y = new int[n];
        for(int i = 0; i < n; ++i) {
            x[i] = in.i();
            y[i] = in.i();
        }

        Map<Pair, Integer> map = new HashMap<>(n * n);
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                Pair mid = new Pair(x[i] + x[j], y[i] + y[j]);
                addToMap(map, mid);
            }
        }

        long ans = 0;
        for(Pair key : map.keySet()) {
            long cnt = map.get(key);
            ans += (cnt - 1L) * cnt / 2;
        }

        out.println(ans);
    }

    void addToMap(Map<Pair, Integer> map, Pair key) {
        if(!map.containsKey(key))
            map.put(key, 1);
        else
            map.put(key, map.get(key) + 1);
    }

    class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != pair.first) return false;
            return second == pair.second;

        }

        @Override
        public int hashCode() {
            int result = first;
            result = 5831 * result + second;
            return result;
        }
    }

    final double eps = 1e-7;
    boolean dEqual(double a, double b) {
        return Math.abs(a - b) <= eps;
    }
}