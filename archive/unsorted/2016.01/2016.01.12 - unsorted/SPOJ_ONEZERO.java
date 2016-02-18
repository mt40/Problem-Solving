package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ONEZERO {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        out.println(cal(n, 1));
    }

    String cal(int n, int cur) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair("" + cur, cur % n));
        boolean []vst = new boolean[n];
        int t = 10 % n;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            if(p.v == 0) return p.s;
            vst[p.v] = true;
            /* If the congruence is visited (i.e vst[i] = true)
            then no need to consider it again because it will
            only produce the visited congruences but the string
            is longer (which is not optimal)
             */
            if(!vst[(p.v * t) % n])
                q.add(new Pair(p.s + "0", (p.v * t) % n));
            if(!vst[(p.v * t + 1) % n])
                q.add(new Pair(p.s + "1", (p.v * t + 1) % n));
        }
        return "1";
    }

    class Pair {
        String s;
        int v; // congruence

        public Pair(String s, int v) {
            this.s = s;
            this.v = v;
        }
    }
}