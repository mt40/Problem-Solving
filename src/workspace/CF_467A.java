package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_467A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int ans = 0;

        for(int i = 0; i < n; ++i) {
            int p = in.nextInt();
            int q = in.nextInt();
            if(q - p >= 2)
                ans++;
        }

        out.println(ans);
    }
}
