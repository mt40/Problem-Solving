package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CUTCAKE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        init();
        int t = in.i();
        while(t-- > 0) {
            long pieces = in.l();
            int rs = Collections.binarySearch(ans, pieces);
            if(rs < 0)
                rs = ~rs;
            out.println(rs);
        }
    }

    List<Long> ans;
    long limit = 1000L*1000*1000*100; // 10^11
    void init() {
        ans = new ArrayList<>();
        long cut = 0;
        while(true) {
            long pieces = 1L + cut*(cut+1)/2;
            ans.add(pieces);
            if(pieces > limit)
                break;
            cut++;
        }
    }
}