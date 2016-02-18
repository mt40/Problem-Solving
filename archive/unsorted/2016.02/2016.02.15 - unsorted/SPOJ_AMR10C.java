package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_AMR10C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();

        int ans = 1;
        int lim = (int)Math.sqrt(n) + 1;
        for(int i = 2; i <= lim;) {
            int cnt = 0;
            while(n % i == 0) {
                n /= i;
                cnt++;
            }
            ans = Math.max(cnt, ans);

            if(i > 2) i += 2;
            else i++;
        }

        out.println(ans);
    }
}