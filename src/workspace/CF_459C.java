package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_459C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt(), d = in.nextInt();
        if(n > Math.pow(k,d)) {
            out.println(-1);
        }
        else {
            for(int i = 1; i <= d; ++i) {
                int e = d - i, cur = 1;
                long step = (int)Math.pow(k,e);
                for(int j = 1; j <= n; ++j) {
                    out.print(cur + " ");
                    if(j % step == 0) {
                        cur++;
                        if(cur > k) cur = 1;
                    }
                }
                out.println();
            }
        }
    }
}
