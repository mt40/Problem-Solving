package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BitwiseMultiplication {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        out.println(multiply(n, m));
    }

    /**
     * Multiplication without using the * operator
     * Russian Peasant Multiplication method
     * http://www.geeksforgeeks.org/fast-multiplication-method-without-using-multiplication-operator-russian-peasants-algorithm/
     */
    public int multiply(int a, int b) {
        int rs = 0;
        while(b > 0) {
            if((b & 1) == 1) {
                rs += a;
            }
            a <<= 1;
            b >>= 1;
        }
        return rs;
    }
}
