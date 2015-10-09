package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MaxSubmatrixContains1 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int [][]a = new int[n][m];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                a[i][j] = in.nextInt();

        int [][]prefix = new int[n][m];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                int one = a[i][j];
                prefix[i][j] = (j > 0) ? prefix[i][j - 1] + one : one;
            }
        }

        int max_area = 0;
        for(int l = 0; l < m; ++l) {
            for(int r = l; r < m; ++r) {
                int len = r - l + 1;
                int area = 0, row = 0;
                while(row < n && count(prefix, l, r, row) == len) {
                    area += len;
                    row++;
                }
                max_area = Math.max(area, max_area);
            }
        }

        out.println(max_area);
    }

    int count(int [][]prefix, int l, int r, int row) {
        if(l == 0)
            return prefix[row][r];
        return prefix[row][r] - prefix[row][l - 1];
    }
}
