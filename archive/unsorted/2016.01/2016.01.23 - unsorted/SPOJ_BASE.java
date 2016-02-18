package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BASE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            char []num;
            try { num = in.c(); }
            catch(Exception e) {return;}
            int x = in.i(), y = in.i();

            String s = toBase(to10(num, x), y);
            if(s.length() > 7)
                out.println("  ERROR");
            else
                out.printf("%7s\n", s);
        }
    }

    long to10(char []c, int a) {
        long rs = 0;
        for(int i = c.length - 1, k = 1; i >= 0; --i, k *= a) {
            rs += val(c[i]) * k;
        }
        return rs;
    }

    String toBase(long x, int b) {
        String rs = "";
        while(x > 0) {
            int m = (int)x % b;
            rs = map[m] + rs;
            x /= b;
        }
        return rs;
    }

    char []map = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    int val(char c) {
        if(Character.isDigit(c)) return c - '0';
        return c - 'A' + 10;
    }
}