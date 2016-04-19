package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PAIRSUM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        long []sqrSum = new long[n];
        long []sum = new long[n];
        for(int i = 0; i < n; ++i) {
            sqrSum[i] = (i > 0) ? sqrSum[i - 1] + sqr(a[i]) : sqr(a[i]);
            sum[i] = (i > 0) ? sum[i - 1] + a[i] : a[i];
        }

        int m = in.i();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; ++i) {
            int low = in.i(), hi = in.i();
            long square = sqr(get(sum, low, hi));
            long diag = get(sqrSum, low, hi);
            long ans = (square + diag) >> 1;
            sb.append(ans).append("\n");
        }
        out.print(sb);
    }

    long get(long []arr, int l, int r) {
        if(l == 0) return arr[r];
        return arr[r] - arr[l - 1];
    }

    long sqr(long x) {
        return x * x;
    }
}