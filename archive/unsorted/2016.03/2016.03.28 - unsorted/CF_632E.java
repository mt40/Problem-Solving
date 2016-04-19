package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_632E {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);

        a = Util.unique(a);
        Arrays.sort(a);
        n = a.length;

        /**
         * The idea is to turn the smallest element to 0.
         * So if we can find a sum x of 1->k elements, then
         * we can add as many 0s as we want to make it to k
         * elements
         * dp[x] = least number of elements required to form
         * sum x
         * This idea and super smart implementation is taken
         * from 2 CF comments below:
         * http://codeforces.com/blog/entry/43493?#comment-282065
         * http://codeforces.com/blog/entry/43493?#comment-282062
         */
        int min = a[0];
        for(int i = 0; i < n; ++i)
            a[i] -= min; // turn a[0] into 0

        int max = k * a[n - 1];
        int []dp = new int[max + 1];
        Arrays.fill(dp, 1, max + 1, k + 1);
        for(int i = 1; i < n; ++i) {
            for(int j = a[i]; j <= max; ++j) {
                dp[j] = Math.min(dp[j - a[i]] + 1, dp[j]);
            }
        }

        for(int i = 0; i <= max; ++i) {
            if(dp[i] <= k) {
                int realSum = i + k * min;
                out.print(realSum + " ");
            }
        }
        out.println();
    }
}