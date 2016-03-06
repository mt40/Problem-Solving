package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MAXSUMSQ {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int[] a = in.arr(n);

        long max = -inf + 1001, cntMax = 0;
        long min = 0, cntMin = 1;
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += a[i];
            if(sum - min > max) {
                max = sum - min;
                cntMax = cntMin;
            }
            else if(sum - min == max) {
                cntMax += cntMin;
            }

            if(sum < min) {
                min = sum;
                cntMin = 1;
            }
            else if (sum == min) {
                cntMin++;
            }
        }

        out.printf("%d %d\n", max, cntMax);
    }
}