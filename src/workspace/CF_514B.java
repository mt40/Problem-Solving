package workspace;

import helperClasses.InputReader;
import javafx.util.Pair;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CF_514B {
    int n, x0, y0;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        x0 = in.nextInt();
        y0 = in.nextInt();

        int []X = new int[n];
        int []Y = new int[n];
        for(int i = 0; i < n; ++i) {
            X[i] = in.nextInt();
            Y[i] = in.nextInt();
        }

        int []mark = new int[n];
        int ans = 0;
        // choose the second point
        for(int i = 0; i < n; ++i) {
            if(mark[i] == 0) {
                mark[i] = 1;
                // choose any other point on the same line
                for (int j = 0; j < n; ++j) {
                    if (mark[j] == 0) {
                        if(check(X[i], Y[i], X[j], Y[j]))
                            mark[j] = 1;
                    }
                }
                ans++;
            }
        }

        out.println(ans);
    }

    boolean check(int x1, int y1, int x2, int y2) {
        return (y0 - y1) * (x0 - x2) == (y0 - y2) * (x0 - x1);
    }
}
