package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BitwiseSubtraction {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        out.println(subtract(n, m));
    }

    int subtract(int a, int b) {
        while(b != 0) {
            int carry = (~a) & b; // carry = 1 n?u bit c?a a và b tai cung 1 v? trí là khác nhau
            a = a ^ b; // addition without carry
            b = carry << 1; // move the carry to subtract in the next iteration
        }
        return a;
    }
}
