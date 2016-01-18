package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_460C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt(), w = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) a[i] = in.nextInt();

        int hi = (int)(1e9 + 1e5);
        int low = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i) low = Math.min(a[i], low);
        int ans = low;

        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            long cost = 0, add = 0;
            long []seg = new long[n];
            for(int i = 0; i < n; ++i) {
                add -= (i - w >= 0) ? seg[i - w] : 0;
                long dif = Math.max(0, mid - a[i] - add);
                cost += dif;
                seg[i] = dif;
                add += seg[i];
            }
            if(cost <= m) {
                low = mid + 1;
                ans = Math.max(mid, ans);
            }
            else
                hi = mid - 1;
        }

        out.println(ans);
    }
}
