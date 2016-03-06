package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CC_CHEFSPL {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c();
        int n = a.length;

        boolean ans;
        if((n & 1) == 0)
            ans = check(a, 0, n/2-1, n/2, n-1, 0);
        else {
            boolean left = check(a, 0, n/2, n/2 + 1, n-1, 1);
            boolean right = check(a, n/2, n-1, 0, n/2-1, 1);
            ans = left | right;
        }

        out.println(ans ? "YES" : "NO");
    }

    boolean check(char []a, int l1, int r1, int l2, int r2, int tolerance) {
        if(r2 - l2 + 1 == 0) return false; // length = 0
        int error = 0, i = l1, j = l2;
        while(i <= r1 && j <= r2) {
            if(a[i] == a[j]) {
                i++;
                j++;
            }
            else {
                error++;
                if(error > tolerance) return false;
                i++;
            }
        }
        if(i == r1 + 1 && j == r2 + 1) return true;
        if(i == r1 && j == r2 + 1 && error == tolerance - 1) return true;
        return false;
    }
}