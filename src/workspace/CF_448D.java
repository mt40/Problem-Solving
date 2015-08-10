package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_448D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long k = in.nextLong();

        long ans = 0;
        long low = 1, hi = 250000000000l;
        while(low <= hi) {
            long mid = (low + hi) / 2l;
            long smaller = 0;
            for(int i = 0; i < n; ++i) {
                smaller += Math.min((mid - 1) / (i + 1), m);
            }
            if(smaller < k) {
                low = mid + 1;
                ans = Math.max(ans, mid);
            }
            else
                hi = mid - 1;
        }

        out.println(ans);
    }
}
