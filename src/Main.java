import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
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
        SPOJ_LCS solver = new SPOJ_LCS();
        solver.solve(1, in, out);
        out.close();
    }

    static class SPOJ_LCS {
        int[][] rank;
        Comparator<Entry> cprt = (o1, o2) -> {
            int t = Integer.compare(o1.l, o2.l);
            return (t == 0) ? Integer.compare(o1.r, o2.r) : t;
        };

        public void solve(int testNumber, InputReader input, PrintWriter out) {
            FastScanner in = new FastScanner(input);
            char[] a = in.c(), b = in.c();
            int n = a.length, m = b.length, k = n + m;

            char[] ab = Util.join(a, b);
            int[] sa = buildSuffixArr(ab);
            Pair[] sorted = new Pair[k];
            for (int i = 0; i < k; ++i)
                sorted[i] = new Pair(sa[i], i);
            Arrays.sort(sorted, (o1, o2) -> Integer.compare(o1.a, o2.a));

            int ans = 0;
            for (int i = 0; i < k - 1; ++i) {
                if (sorted[i].b < n && sorted[i + 1].b >= n) {
                    ans = Math.max(lcp(sorted[i].b, sorted[i + 1].b, k), ans);
                }
            }

            out.println(ans);
        }

        int lcp(int x, int y, int n) {
            int log = (int) Math.ceil(Math.log(n) / Math.log(2));

            if (x == y) return n - x;

            int rs = 0;
            for (int j = log - 1; j >= 0 && x < n && y < n; --j) {
                int len = 1 << j;
                if (rank[j][x] == rank[j][y]) {
                    x += len;
                    y += len;
                    rs += len;
                }
            }
            return rs;
        }

        int[] buildSuffixArr(char[] src) {
            int n = src.length;
            int log = (int) Math.ceil(Math.log(n) / Math.log(2));

            Entry[] sf = new Entry[n];
            rank = new int[log][n];
            for (int i = 0; i < n; ++i) sf[i] = new Entry();

            for (int i = 0; i < n; ++i)
                rank[0][i] = src[i] - 'a';
            for (int j = 1; j < log; ++j) {
                int half = 1 << (j - 1);
                // merge
                for (int i = 0; i < n; ++i) {
                    sf[i].l = rank[j - 1][i];
                    sf[i].r = (i + half < n) ? rank[j - 1][i + half] : -1;
                    sf[i].pos = i;
                }

                Arrays.sort(sf, cprt);
                // assign new rank
                for (int i = 0; i < n; ++i) {
                    if (i == 0) rank[j][sf[i].pos] = 0;
                    else {
                        int prev = rank[j][sf[i - 1].pos];
                        rank[j][sf[i].pos] = sf[i].equals(sf[i - 1]) ? prev : prev + 1;
                    }
                }
            }
            return rank[log - 1];
        }

        class Entry {
            int pos;
            int l;
            int r;

            boolean equals(Entry e) {
                return l == e.l && r == e.r;
            }

        }

        class Pair {
            int a;
            int b;

            public Pair(int a, int b) {
                this.a = a;
                this.b = b;
            }

        }

    }

    static class FastScanner {
        InputReader in;

        public FastScanner(InputReader in) {
            this.in = in;
        }

        public char[] c() {
            return c(false);
        }

        public char[] c(boolean from1) {
            char[] tmp = in.next().toCharArray();
            if (from1) {
                char[] a = new char[tmp.length + 1];
                System.arraycopy(tmp, 0, a, 1, a.length - 1);
                return a;
            }
            return tmp;
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

    }

    static class Util {
        public static char[] join(char[]... ar) {
            int n = 0;
            for (char[] c : ar) n += c.length;
            char[] rs = new char[n];
            int i = 0;
            for (char[] ari : ar)
                for (char c : ari)
                    rs[i++] = c;
            return rs;
        }

    }
}

