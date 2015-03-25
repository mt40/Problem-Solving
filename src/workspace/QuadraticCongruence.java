package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class QuadraticCongruence {
    int a, p; // find x where x^2 = a mod p
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        a = in.nextInt();
        p = in.nextInt();

        out.println(cal());
    }

    public long cal() {
        for(long i = 0; true; ++i) {
            if(i * i % p == a)
                return i;
        }
    }
}
