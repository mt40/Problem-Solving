package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_467B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[] p = new int[m + 1];
        for (int i = 1; i <= m; ++i)
            p[i] = in.nextInt();
        int Fedor = in.nextInt();

        int ans = 0;
        for(int i = 1; i <= m; ++i) {
            if(countDif(Fedor, p[i]) <= k)
                ans++;
        }
        out.println(ans);
    }

    int countDif(int a, int b) {
        int cnt = 0;
        for(int i = 0; i < 32; ++i) {
            int mask = 1 << i;
            cnt += ((mask & a) ^ (mask & b)) > 0 ? 1 : 0;
        }
        return cnt;
    }
}

