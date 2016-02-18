package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_596A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []x = new int[n];
        int []y = new int[n];
        for(int i = 0; i < n; ++i) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        int area = -1;
        if(n > 2 || (n == 2 && x[0] != x[1] && y[0] != y[1])) {
            int w = 0, h = 0;
            for(int i = 1; i < n; ++i) {
                w = Math.max(Math.abs(x[0] - x[i]), w);
                h = Math.max(Math.abs(y[0] - y[i]), h);
            }
            area = w * h;
        }

        out.println(area);
    }
}
