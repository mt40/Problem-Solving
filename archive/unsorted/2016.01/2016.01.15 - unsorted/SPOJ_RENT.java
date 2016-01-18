package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RENT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Order []a = new Order[n];
        for(int i = 0; i < n; ++i)
            a[i] = new Order(in.i(), in.i(), in.i());

        Arrays.sort(a);
        int []dp = new int[n];
        for(int i = n - 1; i >= 0; --i) {
            if(i < n - 1)
                dp[i] = dp[i + 1]; // not choose this order
            dp[i] = Math.max(a[i].pr, dp[i]);
            int next = find(a, a[i].st + a[i].len);
            if(next > 0)
                dp[i] = Math.max(a[i].pr + dp[next], dp[i]);
        }

        out.println(dp[0]);
    }

    int find(Order []a, int key) {
        int low = 0, hi = a.length - 1, rs = -1;
        while(low <= hi) {
            int m = low + (hi - low) / 2;
            if(a[m].st > key) {
                rs = m;
                hi = m - 1;
            }
            else low = m + 1;
        }
        return rs;
    }

    class Order implements Comparable<Order> {
        int st, len, pr; // start time, duration, price

        public Order(int st, int len, int pr) {
            this.st = st;
            this.len = len;
            this.pr = pr;
        }

        @Override
        public int compareTo(Order o) {
            return Integer.compare(st, o.st);
        }
    }
}