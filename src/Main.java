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
        SPOJ_ROBBERY2 solver = new SPOJ_ROBBERY2();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SPOJ_ROBBERY2 {
        public void solve(int testNumber, InputReader input, PrintWriter out) {
            FastScanner in = new FastScanner(input);
            long n = in.l(), k = in.l();

            long t = bSearch(n, k);
            long left = n - f(k, t);
            for (int i = 1; i <= k; ++i) {
                long coins = i * t + csc(t - 1) * k;
                long last = k * t + i;
                coins += Math.min(last, left);
                left = Math.max(left - last, 0);

                out.print(Long.toUnsignedString(coins) + " ");
            }
            out.println();
        }

        long bSearch(long n, long k) {
            long low = 0, hi = n / k, rs = low;
            while (low <= hi) {
                long m = low + (hi - low) / 2;
                long coins = f(k, m);
                if (Long.compareUnsigned(coins, n) <= 0) {
                    rs = m;
                    low = m + 1;
                }
                else hi = m - 1;
            }
            return rs;
        }

        long f(long k, long x) {
            return x * csc(k) + k * k * csc(x - 1);
        }

        long csc(long n) {
            if (n <= 0) return 0;
            return Long.divideUnsigned(n * (n + 1), 2);
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }

    static class FastScanner {
        InputReader in;

        public FastScanner(InputReader in) {
            this.in = in;
        }

        public long l() {
            return in.nextLong();
        }

    }
}

