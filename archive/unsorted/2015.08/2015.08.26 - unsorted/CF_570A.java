package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_570A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []ans = new int[n];
        int [][]vote = new int[m][n];

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                vote[i][j] = in.nextInt();
            }
        }

        for(int i = 0; i < m; ++i) {
            int max = findMax(vote[i]);
            for(int j = 0; j < n; ++j) {
                if(vote[i][j] == max) {
                    ans[j]++;
                    break;
                }
            }
        }

        int max = findMax(ans);
        for(int i = 0; i < n; ++i) {
            if(ans[i] == max) {
                out.println(i + 1);
                return;
            }
        }
    }

    int findMax(int []a) {
        int max = a[0];
        for(int x : a) {
            max = Math.max(max, x);
        }
        return max;
    }
}
