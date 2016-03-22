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
        SPOJ_EMTY2 solver = new SPOJ_EMTY2();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SPOJ_EMTY2 {
        public void solve(int testNumber, InputReader input, PrintWriter out) {
            FastScanner in = new FastScanner(input);
            String s = in.sl();
            char[] num = s.toCharArray();

            int one = 0, zero = 0;
            boolean flag = false, ans = true;
            for (char c : num) {
                if (c == '0') {
                    if (flag) {
                        one--;
                        if (one < 0) ans = false;
                        flag = false;
                        zero--;
                    } else {
                        flag = true;
                        zero++;
                    }
                } else
                    one++;
            }
            if (one + zero != 0)
                ans = false;

            out.printf("Case %d: ", testNumber);
            if (ans)
                out.println("yes");
            else
                out.println("no");
        }

    }

    static class FastScanner {
        InputReader in;

        public FastScanner(InputReader in) {
            this.in = in;
        }

        public String sl() {
            return in.nextLine();
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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

