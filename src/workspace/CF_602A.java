package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_602A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n1 = in.nextInt(), b1 = in.nextInt();
        long x = 0;
        for(int i = n1 - 1; i >= 0; --i) {
            x += (long)in.nextInt() * Math.pow(b1, i);
        }

        int n2 = in.nextInt(), b2 = in.nextInt();
        long y = 0;
        for(int i = n2 - 1; i >= 0; --i) {
            y += (long)in.nextInt() * Math.pow(b2, i);
        }

        int ans = Long.compare(x, y);
        if(ans == 0)
            out.println('=');
        else if(ans < 0)
            out.println('<');
        else
            out.println('>');
    }
}
