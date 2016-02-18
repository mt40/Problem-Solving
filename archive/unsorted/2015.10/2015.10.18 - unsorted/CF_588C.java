package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_588C {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int MAX = 2000000;
        int n = in.nextInt();
        int []w = new int[n];
        for(int i = 0; i < n; ++i) {
            w[i] = in.nextInt();
        }

        int []f = new int[2000000];
        for(int i : w)
            f[i]++;

        for(int i = 0; i < 2000000; ++i) {
            if(f[i] >= 2) {
                int merge = f[i] / 2;
                f[i] -= merge * 2;
                f[i + 1] += merge;
            }
        }

        int ans = 0;
        for(int i : f)
            if(i > 0)
                ans++;
        out.println(ans);
    }
}
