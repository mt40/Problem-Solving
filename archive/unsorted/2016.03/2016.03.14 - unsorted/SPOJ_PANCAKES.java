package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PANCAKES {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int n = in.i(), r = in.i();
            if(n == 0 && r == 0) return;
            int[] ingredients = in.arr(n);
            int[][] recipes = in.arr(r, n);

            int maxRecipe = 0, maxCakes = 0;
            for (int i = 0; i < r; ++i) {
                int cakes = inf;
                for (int j = 0; j < n; ++j) {
                    if (recipes[i][j] != 0)
                        cakes = Math.min((int)(ingredients[j]*10.0 / recipes[i][j]), cakes);
                }
                if (cakes > maxCakes) {
                    maxCakes = cakes;
                    maxRecipe = i;
                }
            }

            out.printf("%d %d\n", maxRecipe + 1, maxCakes);
        }
    }
}