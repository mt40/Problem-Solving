package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_469B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int p = in.nextInt();
        int q = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();

        int []time = new int[1001];
        for(int i = 0; i < p; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            for(int j = x; j <= y; ++j)
                time[j] = 1;
        }

        int [][]b = new int[q][2];
        for(int i = 0; i < q; ++i)
            for(int j = 0; j < 2; ++j)
                b[i][j] = in.nextInt();

        int ans = 0;
        for(int i = l; i <= r; ++i) {
            for(int j = 0; j < q; ++j) {
                int x = b[j][0] + i;
                int y = b[j][1] + i;
                for(int k = x; k <= y; ++k) {
                    if(k <= 1000 && time[k] == 1) {
                        ans++;
                        // break 2 loops
                        k = y; j = q;
                    }
                }
            }
        }

        out.println(ans);
    }
}
