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
		test_project solver = new test_project();
		solver.solve(1, in, out);
		out.close();
	}
}

class test_project {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next();
        char []a = s.toCharArray();
        char []b = in.next().toCharArray();
        int n = a.length, m = b.length;

        int ans = 0, pos = 0;
        int [][]LCSuffix = new int[n][m];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(i == 0 && j == 0 && a[i] == b[j])
                    LCSuffix[i][j] = 1;
                else if(a[i] == b[j])
                    LCSuffix[i][j] = LCSuffix[i - 1][j - 1] + 1;

                if(LCSuffix[i][j] > ans) {
                    ans = LCSuffix[i][j];
                    pos = i;
                }
            }
        }

        out.println(ans);
        out.println(s.substring(pos - ans + 1, pos + 1));
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

}

