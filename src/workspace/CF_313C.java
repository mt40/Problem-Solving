package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CF_313C {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Integer []a = new Integer[n];
        for(int i = 0; i < n; ++i) {
            a[i] = (Integer)in.nextInt();
        }

        Arrays.sort(a);

        long ans = 0;
        if(n == 1) {
            ans = a[0];
        }
        else {
            for(int len = 1; len <= n; len *= 4) {
                for(int i = n - 1; i >= n - len; --i) {
                    ans += a[i] * 1l;
                }
            }
        }

        out.println(ans);
    }
}
