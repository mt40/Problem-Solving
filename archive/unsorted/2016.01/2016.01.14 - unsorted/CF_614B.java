package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_614B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        String t = "1", ans = "";
        int len = 0;
        boolean hasZero = false;
        for(int i = 0; i < n; ++i) {
            String s = in.s();
            char []a = s.toCharArray();
            if(s.equals("0")) hasZero = true;
            int zero = check(a);
            if(zero < 0)
                t = s;
            else
                len += zero;
        }

        if(hasZero)
            out.println(0);
        else {
            out.print(t);
            for (int i = 0; i < len; ++i)
                out.print(0);
            out.println();
        }
    }

    int check(char []a) {
        int zero = 0, one = 0;
        for(char c : a) {
            if(c != '0' && c != '1') return -1;
            if(c == '0') zero++;
            if(c == '1') one++;
        }
        return (one > 1) ? -1 : zero;
    }
}