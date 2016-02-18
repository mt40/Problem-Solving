package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CNEASY {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        HashSet<String> set = new HashSet<>();
        double []tmp = new double[n];
        int sz = 0;
        for(int i = 0; i < n; ++i) {
            in.s();
            String sd = in.s();
            if(set.contains(sd)) continue;
            set.add(sd);
            tmp[sz++] = Double.parseDouble(sd);
        }

        // shrink
        double []a = new double[sz];
        System.arraycopy(tmp, 0, a, 0, sz);

        Arrays.sort(a);
        int ans = inf;
        for(int i = 0; i < sz; ++i) {
            int time = cal(a[(i - 1 + sz) % sz], a[i]);
            ans = Math.min(time, ans);
        }
        //ans = Math.min(cal(a[sz - 1], a[0]), ans);
        if(sz == 1) ans = 0;

        out.println(ans);
    }

    int cal(double d1, double d2) {
        if(d1 < d2) d1 += 360;
        return (int)Math.ceil((d1 - d2) * 12);
    }
}