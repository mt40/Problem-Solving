package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_670B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);

        long []index = new long[n + 1];
        for(int i = 1; i <= n; ++i) {
            index[i] = i + index[i - 1];
        }

        int pos = Arrays.binarySearch(index, k);
        if(pos < 0)
            pos = ~pos;
        pos--;
        long ans = a[(int)(k - index[pos] - 1)];
        out.println(ans);
    }
}