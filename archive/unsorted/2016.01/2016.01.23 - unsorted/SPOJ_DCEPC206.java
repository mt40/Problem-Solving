package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_DCEPC206 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        BIT tree = new BIT();
        long ans = 0;
        for(int i = 0; i < n; ++i) {
            int ai = a[i];
            ans += tree.sum(ai - 1);
            tree.add(ai);
        }

        out.println(ans);
    }

    class BIT {
        long []arr = new long[1000*1000+1];

        void add(int x) {
            int i = x;
            while(i < arr.length) {
                arr[i] += x;
                i += i & (-i);
            }
        }

        long sum(int r) {
            int i = r;
            long rs = 0;
            while(i > 0) {
                rs += arr[i];
                i -= i & (-i);
            }
            return rs;
        }
    }
}