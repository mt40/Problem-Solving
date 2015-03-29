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
		SPOJ_GNYR09F solver = new SPOJ_GNYR09F();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class SPOJ_GNYR09F {
    int n, k;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int id = in.nextInt();
        n = in.nextInt();
        k = in.nextInt();

        int [][][]dp = new int[n + 1][k + 1][2];
        dp[1][0][0] = dp[1][0][1] = 1;
        for(int i = 2; i <= n; ++i) {
            for(int j = 0; j < i && j <= k; ++j) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                dp[i][j][1] = dp[i - 1][j][0];
                if(j > 0)
                    dp[i][j][1] += dp[i - 1][j - 1][1];
            }
        }

        out.printf("%d %d\n", id, dp[n][k][0] + dp[n][k][1]);
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

