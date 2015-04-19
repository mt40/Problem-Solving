package workspace;

import helperClasses.InputReader;
import jdk.internal.util.xml.impl.Pair;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class SPOJ_MBEEWALK {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int [][][]dp = new int[100][100][15];
        dp[50][50][0] = 1;
        for(int len = 1; len <= 14; ++len) {
            for(int i = 1; i < 100; ++i) {
                for(int j = 1; j < 100; ++j) {
                    if(dp[i][j][len - 1] > 0 || (i == 50 && j == 50 && len == 1)) {
                        int walk = dp[i][j][len-1];

                        dp[i - 1][j][len] += walk;
                        dp[i - 1][j - 1][len] += walk;
                        dp[i][j - 1][len] += walk;
                        dp[i][j + 1][len] += walk;
                        dp[i + 1][j + 1][len] += walk;
                        dp[i + 1][j][len] += walk;
                    }
                }
            }
        }

        int test = in.nextInt();
        for(int i = 0; i < test; ++i) {
            int n = in.nextInt();
            out.println(dp[50][50][n]);
        }
    }

}
