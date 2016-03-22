package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_IKEYB {
    int inf = Integer.MAX_VALUE;
    int [][]pi;
    PrintWriter out;
    char []keys, letters;
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        SPOJ_IKEYB.this.out = out;
        int k = in.i(), l = in.i();
        keys = in.c();
        letters = in.c();
        int n = keys.length, m = letters.length;
        int[] f = in.arr(m, true);

        // dp(i,j) = dap an cho i keys va j letters
        long[][] dp = new long[k + 1][m + 1];
        pi = new int[k+1][l+1];
        for (int i = 1; i <= l; ++i) {
            dp[1][i] = dp[1][i - 1] + f[i] * i;
            pi[1][i] = 1;
        }
        for (int i = 2; i <= k; ++i) {
            for (int j = i-1; j <= l; ++j) {
                if (dp[i-1][j] == 0) continue;
                long row = 0;
                for(int idx = j + 1; idx <= l; ++idx) {
                    int h = idx - j;
                    row += f[idx] * h;
                    long old = dp[i][idx];
                    if(old == 0 || dp[i-1][j] + row < old) {
                        dp[i][idx] = dp[i-1][j] + row;

                        pi[i][idx] = j+1;
                    }
                }
            }
        }

//        for (int i = 1; i <= k; ++i)
//            System.out.printf("%c: %s\n", keys[i - 1], Arrays.toString(dp[i]));
//        out.println(dp[k][m]);

        if(testNumber > 1)
            out.println();
        //analyse(in, f, k);

        out.printf("Keypad #%d:\n", testNumber);
        print(k, l);
    }

    void print(int k, int l) {
        if(k <= 0) return;
        print(k-1, pi[k][l] - 1);
        out.printf("%c: ", keys[k-1]);
        for(int i = pi[k][l]; i <= l; ++i)
            out.print(letters[i-1]);
        out.println();
    }

//    void analyse(FastScanner in, int []f, int k) {
//        in.sl();
//        long total = 0;
//        for(int i = 0; i < k; ++i) {
//            String s = in.sl();
//            if(s == null) break;
//            char []a = s.substring(3).toCharArray();
//            for(int j = 1; j <= a.length; ++j)
//                total += f[j]*j;
//        }
//        System.out.println("true: " + total);
//    }

    class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}