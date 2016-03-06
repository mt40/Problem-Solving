package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_629B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Friend []a = new Friend[n];
        for(int i = 0; i < n; ++i)
            a[i] = new Friend(in.s().charAt(0), in.i(), in.i());

        int ans = 0;
        for(int i = 1; i <= 366; ++i) {
            int m = 0, f = 0;
            for(Friend ai : a) {
                if(ai.l <= i && i <= ai.r) {
                    if(ai.sex == 'M') m++;
                    else f++;
                }
            }
            int avail = Math.min(m, f);
            ans = Math.max(avail*2, ans);
        }

        out.println(ans);
    }

    class Friend {
        char sex;
        int l, r;

        public Friend(char sex, int l, int r) {
            this.sex = sex;
            this.l = l;
            this.r = r;
        }
    }
}