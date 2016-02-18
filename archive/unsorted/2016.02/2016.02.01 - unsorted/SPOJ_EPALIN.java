package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_EPALIN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            char []c;
            try{c = in.c();}
            catch(Exception e) {return;}
            if(c.length == 0) return;

            String ans = cal(c);
            out.println(ans);
        }
    }

    String cal(char []c) {
        int n = c.length;
        int []f = new int[n];
        for(int i = 0, j = n - 1; i < n; ++i) {
            if(c[i] == c[j]) {
                f[i] = (i > 0) ? 1 + f[i - 1] : 1;
                j--;
            }
            else {
                j = n - 1;
                if(c[i] == c[j]) {
                    f[i] = 1;
                    j--;
                }
            }
        }

        String rs = String.valueOf(c);
        rs += reverse(rs.substring(0, n - f[n-1]));
        return rs;
    }

    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}