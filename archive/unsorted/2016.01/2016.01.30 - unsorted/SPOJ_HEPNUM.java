package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_HEPNUM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            char[] a = in.c();
            char[] b = in.c();
            if(a[0] == '*') return;

            int n = a.length, m = b.length;
            int sa = 0, sb = 0;
            while (sa < n - 1 && a[sa] == '0') sa++;
            while (sb < m - 1 && b[sb] == '0') sb++;

            String x = String.valueOf(Arrays.copyOfRange(a, sa, n));
            String y = String.valueOf(Arrays.copyOfRange(b, sb, m));

            int mx = Math.max(x.length(), y.length());
            int min = Math.min(x.length(), y.length());
            char []zeros = new char[mx-min];
            Arrays.fill(zeros, '0');
            String z = new String(zeros);
            if(x.length() < mx) x = z + x;
            if(y.length() < mx) y = z + y;

            int cpr = x.compareTo(y);
            if (cpr == 0) out.println('=');
            else if (cpr < 0) out.println('<');
            else out.println('>');
        }
    }
}