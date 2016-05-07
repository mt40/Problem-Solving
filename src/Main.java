import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        CF_670B solver = new CF_670B();
        solver.solve(1, in, out);
        out.close();
    }

    static class CF_670B {
        public void solve(int testNumber, InputReader input, PrintWriter out) {
            FastScanner in = new FastScanner(input);
            int n = in.i(), k = in.i();
            int[] a = in.arr(n);

            long[] index = new long[n + 1];
            for (int i = 1; i <= n; ++i) {
                index[i] = i + index[i - 1];
            }

            int pos = Arrays.binarySearch(index, k);
            if (pos < 0)
                pos = ~pos;
            pos--;
            long ans = a[(int) (k - index[pos] - 1)];
            out.println(ans);
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

        public int[] arr(int n) {
            return arr(n, false);
        }

        public int[] arr(int n, boolean from1) {
            int[] a;
            if (from1) {
                a = new int[n + 1];
                for (int i = 1; i <= n; ++i) a[i] = in.nextInt();
            } else {
                a = new int[n];
                for (int i = 0; i < n; ++i) a[i] = in.nextInt();
            }
            return a;
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
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

