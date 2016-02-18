package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_OPCPIZZA {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        int []a = in.arr(n);

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ai : a) {
            if(map.containsKey(ai))
                map.put(ai, map.get(ai) + 1);
            else
                map.put(ai, 1);
        }

        int ans = 0;
        for(int i = 0; i < n; ++i) {
            boolean ok = map.containsKey(m - a[i])
                    && map.containsKey(a[i]);
            if(m - a[i] == a[i] && ok)
                ok &= map.get(a[i]) >= 2;
            if(ok) {
                ans++;
                reduce(map, a[i]);
                reduce(map, m - a[i]);
            }
        }

        out.println(ans);
    }

    void reduce(HashMap<Integer, Integer> map, int key) {
        int v = map.get(key);
        if(v == 1)
            map.remove(key);
        else
            map.put(key, v - 1);
    }
}