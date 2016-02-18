package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ANARC08G {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n, t = 1;
        while ((n = in.i()) > 0) {
            int[][] a = in.arr(n, n);

            int[] get = new int[n], pay = new int[n];
            int ans1 = 0, ans2 = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    ans1 += a[i][j];
                    pay[i] += a[i][j];
                    get[j] += a[i][j];
                }
            }

            for (int i = 0; i < n; ++i)
                if (get[i] - pay[i] > 0)
                    ans2 += get[i] - pay[i];

            out.printf("%d. %d %d\n", t++, ans1, ans2);
        }
    }
}