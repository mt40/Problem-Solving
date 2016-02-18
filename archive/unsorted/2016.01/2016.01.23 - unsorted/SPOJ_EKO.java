package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_EKO {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        long m = in.i();
        int []a = in.arr(n);

        int max = a[0];
        for(int ai : a) max = Math.max(ai, max);

        int low = 0, hi = max, ans = low;
        while(low <= hi) {
            int mid = low + ((hi - low) >> 1);
            long cut = 0;
            for(int i = 0; i < n; ++i) {
                int tmp = a[i];
                if (tmp > mid)
                    cut += tmp - mid;
            }
            if(cut >= m) {
                ans = mid;
                low = mid + 1;
            }
            else hi = mid - 1;
        }

        out.println(ans);
    }
}