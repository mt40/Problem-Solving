package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_463B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n + 1];
        for(int i = 1; i <= n; ++i)
            a[i] = in.nextInt();

        /* find the smallest energy if we don't spend any dollar */
        int ans = Integer.MAX_VALUE;
        int energy = 0;
        for(int i = 0; i < n; ++i) {
            energy += a[i] - a[i + 1];
            if(energy < ans)
                ans = energy;
        }

        out.println(Math.abs(ans));
    }
}
