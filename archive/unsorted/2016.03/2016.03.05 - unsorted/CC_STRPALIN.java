package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CC_STRPALIN {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c(), b = in.c();
        int n = a.length, m = b.length;

        boolean ans = false;

        int []fa = new int[26];
        for(char ai : a)
            fa[ai - 'a']++;
        for(char bi : b)
            if(fa[bi - 'a'] > 0)
                ans = true;

        out.println(ans ? "Yes" : "No");
    }
}