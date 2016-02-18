package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ANARC09C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int t = 1;
        while(true) {
            int a = in.i(), b = in.i();
            if(a == 0 && b == 0) return;

            TreeMap<Integer, Integer> fa = factorize(a);
            TreeMap<Integer, Integer> fb = factorize(b);
            TreeMap<Integer, Integer> fboth = new TreeMap<>();
            fboth.putAll(fa);
            fboth.putAll(fb);

            int d = fboth.size();
            int ans = 0;
            for(Integer f : fboth.keySet()) {
                int xa = get(fa, f);
                int xb = get(fb, f);
                ans += Math.abs(xa - xb);
            }

            out.printf("%d. %d:%d\n", t++, d, ans);
        }
    }

    int get(TreeMap<Integer, Integer> map, int key) {
        if(map.containsKey(key))
            return map.get(key);
        return 0;
    }

    TreeMap<Integer, Integer> factorize(int n) {
        int lim = (int)Math.sqrt(n) + 1;
        TreeMap<Integer, Integer> rs = new TreeMap<>();
        for (int i = 2; i <= lim; ) {
            int cnt = 0;
            while (n % i == 0) {
                n /= i;
                cnt++;
            }
            if (cnt > 0)
                rs.put(i, cnt);
            if(i > 2) i += 2;
            else i++;
        }
        if(n > 1)
            rs.put(n, 1);
        return rs;
    }
}