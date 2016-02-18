package workspace;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_DCEPC504 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        long k = in.l();
        int ans = cal(k-1);
        out.println((ans == 0) ? "Male" : "Female");
    }

    int cal(long k) {
        if(k == 0) return 0;
        return 1 - cal(k - (k & (-k)));
    }
}
