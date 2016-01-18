import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        SPOJ_PTIME solver = new SPOJ_PTIME();
        solver.solve(1, in, out);
        out.close();
    }

    static class SPOJ_PTIME {
        public void solve(int testNumber, InputReader input, PrintWriter out) {
            FastScanner in = new FastScanner(input);
            int n = in.i();
            List<Integer> list = new ArrayList<>();
            int lim = (int) Math.sqrt(n) + 1;
            int[] e = new int[n];
            for (int i = 2; i <= lim; ++i) {
                if (n % i == 0) {
                    list.add(i);
                    while (n % i == 0) {
                        n /= i;
                        e[i]++;
                    }
                }
            }

            for (int i = 0; i < list.size(); ++i) {
                out.printf("%d^%d", list.get(i), e[i]);
                if (i < n - 1) out.print(" * ");
            }
            out.println();
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

