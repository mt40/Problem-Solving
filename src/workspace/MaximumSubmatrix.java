package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

/**
 * Find maximum submatrix in O(n^3) using Kadane alg
 * Does not allow empty submatrix
 */
public class MaximumSubmatrix {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        int [][]mat = in.arr(n, m);

        int [][]prefix = new int[n][m];
        for(int i = 0; i < n; ++i) {
            prefix[i][0] = mat[i][0];
            for(int j = 1; j < m; ++j)
                prefix[i][j] = mat[i][j] + prefix[i][j - 1];
        }

        int maxArea = 0;
        for(int l = 0; l < m; ++l) {
            for(int r = l; r < m; ++r) {
                /**
                 * Here we run the famous Kadane alg to
                 * find max subarray in O(n)
                 */
                int maxHere = 0, maxAll = 0;
                for(int i = 0; i < n; ++i) {
                    int valueHere = get(prefix[i], l, r);
                    maxHere = Math.max(valueHere, maxHere + valueHere);
                    maxAll = Math.max(maxHere, maxAll);
                }
                maxArea = Math.max(maxAll, maxArea);
            }
        }

        out.println(maxArea);
    }

    int get(int []sum, int l, int r) {
        return (l > 0) ? sum[r] - sum[l - 1] : sum[r];
    }
}