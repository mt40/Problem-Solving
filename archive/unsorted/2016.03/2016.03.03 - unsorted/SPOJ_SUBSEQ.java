package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SUBSEQ {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        long []a = in.arrl(n);

        HashMap<Long, Integer> map = new HashMap<>();
        long []pre = new long[n];
        map.put(0L, 1); // there is 1 prefix of sum 0
        long ans = 0;
        for(int i = 0; i < n; ++i) {
            pre[i] = (i > 0) ? pre[i-1] + a[i] : a[i];
            long need = pre[i] - 47;
            if(map.containsKey(need))
                ans += map.get(need);
            add(map, pre[i]);
        }

        out.println(ans);
    }

    void add(HashMap<Long, Integer> map, long key) {
        if(map.containsKey(key))
            map.put(key, map.get(key) + 1);
        else
            map.put(key, 1);
    }
}