import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SPOJ_MAY99_4 solver = new SPOJ_MAY99_4();
        solver.solve(1, in, out);
        out.close();
    }

    static class SPOJ_MAY99_4 {
        int mod = 1000 * 1000 * 10 + 7;
        long[][] dp;

        public void solve(int testNumber, InputReader input, PrintWriter out) {
            FastScanner in = new FastScanner(input);
            int n = in.i(), r = in.i();

            if (n < r) out.println(-1);
            else {
                dp = new long[n][r];
                out.println(comb(n - 1, r - 1) % mod);
            }
        }

        long comb(int n, int k) {
            if (k == 0 || k == n) return 1;
            if (dp[n][k] > 0) return dp[n][k];
            dp[n][k] = comb(n - 1, k - 1) % mod + comb(n - 1, k) % mod;
            return dp[n][k];
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class FastScanner {
        InputReader in;

        public FastScanner(InputReader in) {
            this.in = in;
        }

        public int i() {
            return in.nextInt();
        }

    }
}

