import java.util.LinkedList;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

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
		CF_546D_faster_input solver = new CF_546D_faster_input();
		solver.solve(1, in, out);
		out.close();
	}
}

class CF_546D_faster_input {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Integer []primes = seive();
        long []factors = new long[5000000 + 1];
        for(int i = 0; i < primes.length; ++i) {
            factors[primes[i]] = 1;
        }
        for(int i = 2; i < factors.length; ++i) {
            int num = i;
            if(factors[i] == 0) {
                for(int j = 0; j < primes.length; ++j) {
                    if(num % primes[j] == 0) {
                        int m = num / primes[j];
                        factors[i] = factors[m] + 1;
                        break;
                    }
                }
            }
        }

        long []cul = new long[5000000 + 1];
        for(int i = 2; i < cul.length; ++i) {
            cul[i] = cul[i - 1] + factors[i];
        }

        int T = in.nextInt();
        while(T-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            if(a == b)
                out.println(0);
            else
                out.println(cul[a] - cul[b]);
        }
    }

    Integer[] seive() {
        boolean []nums = new boolean[5000001];
        for(int i = 2; i < nums.length; ++i) {
            if(nums[i] == false) {
                for(int j = 2; j * i < nums.length; ++j) {
                    nums[j * i] = true;
                }
            }
        }

        List<Integer> temp = new LinkedList<Integer>();
        for(int i = 2; i < nums.length; ++i) {
            if(nums[i] == false)
                temp.add(i);
        }

        return temp.toArray(new Integer[temp.size()]);
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

