package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_604A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int []m = new int[5], w = new int[5];
        for(int i = 0; i < 5; ++i) m[i] = in.nextInt();
        for(int i = 0; i < 5; ++i) w[i] = in.nextInt();
        int hs = in.nextInt(), hu = in.nextInt();

        float ans = hs * 100 - hu * 50;
        for(int i = 0; i < 5; ++i) {
            int x = score(i);
            ans += Math.max(0.3 * x, (1 - m[i]*1.0/250) * x - 50 * w[i]);
        }

        out.println((int)Math.floor(ans));
    }

    int score(int i) {
        return (i + 1) * 500;
    }
}
