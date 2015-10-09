package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BitwiseAddition {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        out.println(add(n, m));
    }

    /**
     * Addition without using arithmetic operators
     */
    public int add(int a, int b) {
        while(b != 0) {
            int carry = a & b; // carry = common set bits of a & b
            a = a ^ b; // do addition without carry
            b = carry << 1; // shift carry to add in the next iteration
        }
        return a;
    }
}
