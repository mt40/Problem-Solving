package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_474B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();
        int []pos = new int[1000000 + 1];
        int k = 0, j = a[k];
        for(int i = 1; i <= 1000000; ++i) {
            pos[i] = k;
            if(i == j) {
                k++;
                if(k == n) break;
                j += a[k];
            }
        }

        int m = in.nextInt();
        for(int i = 0; i < m; ++i)
            out.println(pos[in.nextInt()] + 1);
    }
}
