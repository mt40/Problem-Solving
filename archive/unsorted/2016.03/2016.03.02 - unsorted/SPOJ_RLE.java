package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RLE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        String s;
        while((s = in.sl()) != null) {
            char []a = s.toCharArray();
            int n = a.length;

            int i = 1, len = 1;
            char prev = a[0];
            while(i < n) {
                if(a[i] == prev) {
                    while(i < n && a[i] == prev) {
                        len++;
                        i++;
                    }
                }
                else {
                    out.print(compress(prev, len));

                    prev = a[i];
                    len = 1;
                    i++;
                }
            }
            if(len > 0)
                out.print(compress(prev, len));
            out.println();
        }
    }

    String compress(char a, int len) {
        if(len > 3)
            return String.format("%d!%c", len, a);
        else {
            String rs = "";
            while(len-- > 0) rs += a;
            return rs;
        }
    }
}