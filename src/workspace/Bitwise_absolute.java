package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class Bitwise_absolute {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n  = in.nextInt();
        final int mask = n >> 31;
        int ans = (n + mask) ^ mask;

        out.println(ans);
    }
}
