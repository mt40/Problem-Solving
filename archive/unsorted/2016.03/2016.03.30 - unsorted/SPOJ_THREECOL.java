package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_THREECOL {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []c = in.c();
        children = new int[c.length * 3];
        for(int i = 0; i < c.length; ++i)
            children[i] = c[i] - '0';
        int n = c.length;

        dpMax = new int[3][n*3];
        dpMin = new int[3][n*3];
        dpMax[0][0] = dpMin[0][0] = 1;
        index = 0; minGreen = 0; maxGreen = 0;

        cal();
        maxGreen = Util.max(dpMax[0][0], dpMax[1][0], dpMax[2][0]);
        minGreen = Util.min(dpMin[0][0], dpMin[1][0], dpMin[2][0]);

        out.printf("%d %d\n", maxGreen, minGreen);
    }

    int index, minGreen, maxGreen;
    int []children;
    int [][] dpMax, dpMin;
    void cal() {
        int u = index, left = 0, right = 0;
        for(int v = 0; v < children[u]; ++v) {
            ++index;

            if(v == 0) left = index;
            else right = index;
            cal();
        }
        dpMax[0][u] = dpMin[0][u] = 1;
        if(children[u] == 1) {
            dpMax[0][u] = 1 + Math.max(dpMax[1][left], dpMax[2][left]);
            dpMax[1][u] = Math.max(dpMax[0][left], dpMax[2][left]);
            dpMax[2][u] = Math.max(dpMax[0][left], dpMax[1][left]);
            
            dpMin[0][u] = 1 + Math.min(dpMin[1][left], dpMin[2][left]);
            dpMin[1][u] = Math.min(dpMin[0][left], dpMin[2][left]);
            dpMin[2][u] = Math.min(dpMin[0][left], dpMin[1][left]);
        }
        if(children[u] == 2) {
            dpMax[0][u] = 1 + Math.max(dpMax[1][left] + dpMax[2][right],
                    dpMax[2][left] + dpMax[1][right]);
            dpMax[1][u] = Math.max(dpMax[0][left] + dpMax[2][right],
                    dpMax[2][left] + dpMax[0][right]);
            dpMax[2][u] = Math.max(dpMax[0][left] + dpMax[1][right],
                    dpMax[1][left] + dpMax[0][right]);

            dpMin[0][u] = 1 + Math.min(dpMin[1][left] + dpMin[2][right],
                    dpMin[2][left] + dpMin[1][right]);
            dpMin[1][u] = Math.min(dpMin[0][left] + dpMin[2][right],
                    dpMin[2][left] + dpMin[0][right]);
            dpMin[2][u] = Math.min(dpMin[0][left] + dpMin[1][right],
                    dpMin[1][left] + dpMin[0][right]);
        }
    }
}