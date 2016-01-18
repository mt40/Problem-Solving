package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PTIME {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        List<Integer> list = new ArrayList<>();
        int lim = (int)Math.sqrt(n) + 1;
        int []e = new int[n];
        for(int i = 2; i <= lim; ++i) {
            if(n % i == 0) {
                list.add(i);
                while(n % i == 0) {
                    n /= i;
                    e[i]++;
                }
            }
        }

        for(int i = 0; i < list.size(); ++i) {
            out.printf("%d^%d", list.get(i), e[i]);
            if(i < n - 1) out.print(" * ");
        }
        out.println();
    }
}