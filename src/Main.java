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
		SPOJ_ROCK solver = new SPOJ_ROCK();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class SPOJ_ROCK {
    int[] cnt, a;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        char[] tmp = in.next().toCharArray();
        a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = tmp[i] - '0';

        cnt = new int[n];
        cnt[0] = a[0];
        for (int i = 1; i < n; ++i)
            cnt[i] = a[i] == 1 ? cnt[i - 1] + 1 : cnt[i - 1];

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i)
            dp[i][i] = a[i];
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                int one = countOne(i, j);
                int zero = len - one;
                if (one > zero)
                    dp[i][j] = len;
                else
                    dp[i][j] = a[j] == 1 ? dp[i][j - 1] + 1 : dp[i][j - 1];
                // also calculate score inside
                for (int k = i; k < j; ++k)
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j]);
            }
        }

        out.println(dp[0][n - 1]);
    }

    int countOne(int l, int r) {
        return cnt[r] - cnt[l] + a[l];
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

