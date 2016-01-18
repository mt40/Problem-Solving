package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ABA12D {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int t = in.i();
        Integer []pool = cal(1000000);
        while(t-- > 0) {
            int l = in.i(), r = in.i();
            int x = find(pool, l);
            int y = find2(pool, r);
            int ans = 0;
            if(y >= x) ans = y - x + 1;
            out.println(ans);
        }
    }

    int find(Integer []a, int key) {
        int low = 0, hi = a.length - 1, rs = hi;
        while (low <= hi) {
            int m = low + (hi - low) / 2;
            if (a[m] >= key) {
                rs = m;
                hi = m - 1;
            }
            else low = m + 1;
        }
        return rs;
    }

    int find2(Integer []a, int key) {
        int low = 0, hi = a.length - 1, rs = low;
        while (low <= hi) {
            int m = low + (hi - low) / 2;
            if (a[m] <= key) {
                rs = m;
                low = m + 1;
            }
            else hi = m - 1;
        }
        return rs;
    }

    Integer[] cal(int mx) {
        List<Integer> set = new ArrayList<>();
        set.add(2);
        set.add(4);
        int prev = 4;
        for(int gap = 4;;gap += 2) {
            int num = prev + gap + 1;
            if(num > mx) {
                Integer []rs = new Integer[set.size()];
                set.toArray(rs);
                return rs;
            }
            set.add(num);
            prev = num;
        }
    }
}