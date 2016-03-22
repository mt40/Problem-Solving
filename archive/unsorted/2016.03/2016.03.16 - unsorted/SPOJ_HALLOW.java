package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_HALLOW {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int c = in.i(), n = in.i();
            if(c == 0) return;
            int[] a = in.arr(n);

            int[] residue = new int[c];
            Arrays.fill(residue, -1);
            residue[0] = 0;
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                sum = (sum + a[i]) % c;
                if (residue[sum] >= 0) {
                    for (int idx = residue[sum] + 1; idx - 1 <= i; ++idx)
                        out.print(idx + " ");
                    break;
                }
                residue[sum] = i + 1;
            }

            out.println();
        }
    }
}