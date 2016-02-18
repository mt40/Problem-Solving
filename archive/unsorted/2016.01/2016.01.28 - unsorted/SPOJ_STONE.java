package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_STONE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []x = new int[n], y = new int[n];
        for(int i = 0; i < n; ++i) {
            x[i] = in.i();
            y[i] = in.i();
        }

        double gx = 0, gy = 0, area = 0;
        for(int i = 0; i < n - 1; ++i) {
            double val = x[i]*y[i + 1] - x[i + 1]*y[i];
            area = (i == 0) ? val : area + val;
        }
        area /= 2;

        for(int i = 0; i < n - 1; ++i) {
            double val_x = (x[i] + x[i + 1]) * (x[i]*y[i+1] - x[i+1]*y[i]);
            double val_y = (y[i] + y[i + 1]) * (x[i]*y[i+1] - x[i+1]*y[i]);
            gx = (i == 0) ? val_x : gx + val_x;
            gy = (i == 0) ? val_y : gy + val_y;
        }
        gx /= 6*area;
        gy /= 6*area;

        out.printf("%.2f %.2f\n", gx, gy);
    }
}