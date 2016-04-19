package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_XMEN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []magneto = in.arr(n);
        int []wolve = in.arr(n);

        int []map = new int[n+1];
        for(int i = 0; i < n; ++i) {
            map[magneto[i]] = i;
        }

        int []dp = new int[n + 1];
        Arrays.fill(dp, inf);
        int len = 1;
        for(int i = 0; i < n; ++i) {
            int pos = map[wolve[i]];
            int insert = find(dp, pos);
            dp[insert] = pos;
            len = Math.max(len, insert);
        }

        out.println(len);
    }

    int find(int []dp, int key) {
        int i = Arrays.binarySearch(dp, 1, dp.length, key);
        return ~i;
    }
}