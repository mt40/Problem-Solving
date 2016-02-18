package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BOOKS1 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);

        long sum = 0, mx = 0;
        for(int ai : a) {
            sum += ai;
            mx = Math.max(ai, mx);
        }

        long low = mx, hi = sum, ans = hi;
        while(low <= hi) {
            long m = low + (hi - low) / 2;
            if(check(a, n, k, m)) {
                ans = m;
                hi = m - 1;
            }
            else low = m + 1;
        }

        StringBuilder sb = new StringBuilder();
        int cur = 0;k--;
        for(int i = n - 1; i >= 0; --i) {
            if(cur + a[i] > ans || i + 1 == k) {
                cur = 0;
                sb.insert(0, "/ ");
                --k;
            }
            sb.insert(0, a[i] + " ");
            cur += a[i];
        }

        out.println(sb.toString());
    }

    boolean check(int []a, int n, int k, long m) {
        long sum; int i = 0;
        while(k-- > 0) {
            sum = 0;
            int j = 0;
            while(i < n - k && sum + a[i] <= m) {
                sum += a[i];
                j++; i++;
            }
            if(j == 0) return false;
        }
        if(i < n) return false;
        return true;
    }
}