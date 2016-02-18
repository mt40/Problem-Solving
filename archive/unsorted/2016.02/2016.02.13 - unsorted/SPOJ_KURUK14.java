package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_KURUK14 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        int []f = new int[1000+1];
        for(int ai : a)
            f[ai]++;

        boolean ok = true;
        for(int i = 0; i < n; ++i) {
            int l = i, r = n - 1 - i;
            if(f[l] == 0 && f[r] == 0) {
                ok = false;
                break;
            }
            if(f[l] >= f[r])
                f[l]--;
            else
                f[r]--;
        }

        out.println(ok ? "YES" : "NO");
    }
}