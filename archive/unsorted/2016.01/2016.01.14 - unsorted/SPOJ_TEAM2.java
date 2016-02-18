package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SPOJ_TEAM2 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int t = 1;
        while(true) {
            long a, b, c, d;
            try {
                a = in.l();
                b = in.l();
                c = in.l();
                d = in.l();
            } catch(Exception e) {return;}
            long ans = Util.max(a + b, a + c, a + d, b + c, b + c, b + d, c + d);

            out.printf("Case %d: %d\n", t++, ans);
        }
    }
}
