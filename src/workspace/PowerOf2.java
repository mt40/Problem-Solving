package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

// Check if a number is power of 2 in 1 line
public class PowerOf2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        if(isPowerOf2(n))
            out.println("YES");
        else
            out.println("NO");
    }

    boolean isPowerOf2(int x) {
        return x == 1? false : ((x - 1) & x) == 0 ? true : false;
    }
}
