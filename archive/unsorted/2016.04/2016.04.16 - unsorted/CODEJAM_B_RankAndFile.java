package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CODEJAM_B_RankAndFile {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int [][]a = in.arr(2 * n - 1, n);

        int []f = new int[2501];
        for(int i = 0; i < a.length; ++i) {
            for(int ai : a[i])
                f[ai]++;
        }

        Set<Integer> rs = new TreeSet<>();
        for(int i = 0; i < f.length; ++i) {
            if((f[i] & 1) > 0)
                rs.add(i);
        }

        out.printf("Case #%d:", testNumber);
        for(int rsi : rs) {
            out.print(" " + rsi);
        }
        out.println();
    }
}