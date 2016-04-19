package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_660C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);

        int []pre = new int[n];
        pre[0] = (a[0] == 0) ? 1 : 0;
        for(int i = 1; i < n; ++i) {
            pre[i] = pre[i - 1];
            if(a[i] == 0)
                pre[i]++;
        }

        int ans = calc(a, pre, n, k);

        out.println(ans);
        for(int i = 0; i < n; ++i) {
            if(i == rsStart) {
                for(int j = 0; j < ans; ++j)
                    out.print(1 + " ");
                i = i + ans - 1;
            }
            else
                out.print(a[i] + " ");
        }
        out.println();
    }

    int rsStart = -1;
    int calc(int []a, int []pre, int n, int k) {
        int maxLen = 0;
        for(int i = 0; i < n; ++i) {
            int low = i, hi = n - 1;
            while(low <= hi) {
                int mid = (low + hi) >>> 1;
                int len = mid - i + 1;
                if(zeros(pre, i, mid) <= k) {
                    if(len > maxLen) {
                        maxLen = len;
                        rsStart = i;
                    }
                    low = mid + 1;
                }
                else hi = mid - 1;
            }
        }
        return maxLen;
    }

    int zeros(int []pre, int l, int r) {
        if(l == 0)
            return pre[r];
        return pre[r] - pre[l - 1];
    }
}