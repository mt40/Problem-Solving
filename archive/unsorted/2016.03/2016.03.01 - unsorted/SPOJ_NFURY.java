package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NFURY {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        init();
        int t = in.i();
        while(t-- > 0) {
            out.println(ans[in.i()]);
        }
    }

    int []ans;
    List <Integer>isSquare;
    void init() {
        int n = 1000;
        ans = new int[n + 1];
        initSquare(n);

        for(int sqr : isSquare) {
            for(int i = 0; i <= n; ++i) {
                if(i - sqr == 0 || (i - sqr > 0 && ans[i - sqr] > 0)) {
                    if (ans[i] == 0)
                        ans[i] = ans[i - sqr] + 1;
                    else
                        ans[i] = Math.min(ans[i - sqr] + 1, ans[i]);
                }
            }
        }
    }

    void initSquare(int n) {
        isSquare = new ArrayList<>(n+1);
        for(int i = 1; i*i <= n; ++i)
            isSquare.add(i*i);
    }
}