package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_599A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        int ans = Integer.MAX_VALUE;

        int p1 = a + b + c;
        int p2 = a + a + b + b;
        int p3 = a + c + c + a;
        int p4 = b + c + c + b;

        out.println(min(p1, p2, p3, p4));
    }

    int min(int...x) {
        int rs = x[0];
        for(int i = 1; i < x.length; ++i)
            rs = Math.min(x[i], rs);
        return rs;
    }
}
