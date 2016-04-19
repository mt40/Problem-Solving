package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_652C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        int []a = in.arr(n);
        int []pos = new int[n + 1];
        for(int i = 0; i < n; ++i)
            pos[a[i]] = i;

        int []start = new int[n + 1];
        Arrays.fill(start, -1);
        for(int i = 0; i < m; ++i) {
            int x = in.i(), y = in.i();
            if(pos[y] < pos[x])
                start[x] = Math.max(start[x], pos[y]);
            else
                start[y] = Math.max(start[y], pos[x]);
        }

        long ans = 0;
        int left = 0;
        for (int i = 0; i < n; ++i) {
            if (start[a[i]] >= 0 && left <= start[a[i]]) {
                int len = i - left, rightLen = i - start[a[i]] - 1;
                long total = progSum(len);
                long rightSum = progSum(rightLen);
                ans += total - rightSum;

                left = start[a[i]] + 1;
            }
        }
        if(left < n)
            ans += progSum(n - left);

        out.println(ans);
    }

    long progSum(long x) {
        return x * (x + 1) / 2;
    }
}