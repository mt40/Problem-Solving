package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Sieve2 {
    static final int LIMIT = 1000001; // up to 10^6
    static boolean []prime = new boolean[LIMIT];
    static {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i < LIMIT; ++i) {
            if(prime[i])
                for(int m = 2; m * i < LIMIT; ++m)
                    prime[m * i] = false;
        }
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        out.println(prime[n]);
    }
}
