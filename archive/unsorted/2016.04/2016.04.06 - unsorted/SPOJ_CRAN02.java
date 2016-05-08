package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CRAN02 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int []suff = new int[n];
        suff[n - 1] = a[n - 1];
        for(int i = n - 2; i >= 0; --i)
            suff[i] = a[i] + suff[i + 1];

        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            int suffix = suff[i];
            if(suffix == 0) ans++;
            if(map.containsKey(suffix))
                ans += map.get(suffix);

            if(map.containsKey(suffix))
                map.put(suffix, map.get(suffix) + 1);
            else
                map.put(suffix, 1);
        }

        out.println(ans);
    }
}