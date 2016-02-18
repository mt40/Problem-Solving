package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_221A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        String ans = "" + n;
        if(n > 1)
            ans += " 1";
        for(int i = 2; i < n; ++i)
            ans += " " + i;
        out.println(ans);
    }
}
