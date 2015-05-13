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
		CF_515C solver = new CF_515C();
		solver.solve(1, in, out);
		out.close();
	}
}

class CF_515C {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        char[]a = in.next().toCharArray();

        int []nums = new int[10];
        for(int i = 0; i < n; ++i) {
            int x = a[i] - '0';
            for(int j = 1; j <= x; ++j) {
                int tmp = j;
                if(tmp == 1)
                    nums[1]++;
                else {
                    for(int k = 2; k <= j; ++k) {
                        while(tmp % k == 0) {
                            nums[k]++;
                            tmp /= k;
                        }
                    }
                }
            }
        }

        String ans = "";
        for(int i = 9; i >= 1; --i) {
            while(nums[i] > 0) {
                for(int j = 1; j <= i; ++j) {
                    if(j == 4)
                        nums[2] -= 2;
                    else if(j == 6) {
                        nums[2]--; nums[3]--;
                    }
                    else if(j == 8)
                        nums[2] -= 4;
                    else if(j == 9)
                        nums[3] -= 3;
                    else
                        nums[j]--;
                }
                ans += i + "";
            }
        }

        //System.out.println(Arrays.toString(nums));
        out.println(ans);
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

