package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_PlayingWithPaper {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long a = in.nextLong();
        long b = in.nextLong();
        long w = Math.max(a, b), h = Math.min(a, b);

        long ans = 0;
        while(h > 0) {
            ans += w / h;
            long tmp = h;
            h = w % h;
            w = tmp;
        }

        out.println(ans);
    }
}
