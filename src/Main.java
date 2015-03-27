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
		CF_189A solver = new CF_189A();
		solver.solve(1, in, out);
		out.close();
	}
}

class CF_189A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int []dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 0; i <= n; ++i) {
            if(dp[i] > 0 || i == 0) {
                if(i + a <= n)
                    dp[i + a] = Math.max(dp[i + a], dp[i] + 1);
                if(i + b <= n)
                    dp[i + b] = Math.max(dp[i + b], dp[i] + 1);
                if(i + c <= n)
                    dp[i + c] = Math.max(dp[i + c], dp[i] + 1);
            }
        }

        out.println(dp[n]);
        //out.println(Arrays.toString(dp));
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

