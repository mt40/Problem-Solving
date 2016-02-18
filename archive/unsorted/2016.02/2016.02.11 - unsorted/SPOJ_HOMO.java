package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_HOMO {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Op []a = new Op[n];
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < n; ++i) {
            a[i] = new Op(in.s(), in.i());
            set.add(a[i].x);
        }

        // compress
        HashMap<Integer, Integer> map = new HashMap<>(n);
        int id = 0;
        for(int i : set)
            map.put(i, id++);

        int size = id, two = 0, cnt = 0;
        int []f = new int[size];
        for(Op op : a) {
            int x = map.get(op.x);
            if(op.s.equals("insert")) {
                f[x]++;
                if(f[x] == 1)
                    cnt++;
                if(f[x] >= 2)
                    two++;
            }
            else {
                int new_f = Math.max(f[x] - 1, 0);
                if(f[x] > 0 && new_f == 0)
                    cnt--;
                if(f[x] >= 2 && new_f < 2)
                    two--;
                f[x] = new_f;
            }
            out.println(getStr(two, cnt));
        }
    }

    String getStr(int two, int cnt) {
        boolean homo = two > 0;
        boolean hete = cnt > 1;
        if(homo && hete)
            return "both";
        if(homo)
            return "homo";
        if(hete)
            return "hetero";
        return "neither";
    }

    class Op {
        String s;
        int x;

        public Op(String s, int x) {
            this.s = s;
            this.x = x;
        }
    }
}