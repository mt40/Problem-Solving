import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author mthai
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		CF_514B solver = new CF_514B();
		solver.solve(1, in, out);
		out.close();
	}
}

class CF_514B {
    int n, x0, y0;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        x0 = in.nextInt();
        y0 = in.nextInt();

        int []X = new int[n];
        int []Y = new int[n];
        for(int i = 0; i < n; ++i) {
            X[i] = in.nextInt();
            Y[i] = in.nextInt();
        }

        int []mark = new int[n];
        int ans = 0;
        // choose the second point
        for(int i = 0; i < n; ++i) {
            if(mark[i] == 0) {
                mark[i] = 1;
                // choose any other point on the same line
                for (int j = 0; j < n; ++j) {
                    if (mark[j] == 0) {
                        if(check(X[i], Y[i], X[j], Y[j]))
                            mark[j] = 1;
                    }
                }
                ans++;
            }
        }

        out.println(ans);
    }

    boolean check(int x1, int y1, int x2, int y2) {
        return (y0 - y1) * (x0 - x2) == (y0 - y2) * (x0 - x1);
    }
}

class InputReader {
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

