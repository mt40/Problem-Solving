package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_PRIME1 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int m = in.nextInt();
        int n = in.nextInt();

        for(int i = m; i <= n; ++i)
            if(isPrime(i))
                out.println(i);
        out.println();
    }

    public boolean isPrime(int n) {
        if(n <= 1)
            return false;
        int sqrt = (int)Math.sqrt(n) + 1;
        for(int i = 2; i < sqrt; ++i) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
