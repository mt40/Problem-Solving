package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SwapBit {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int i = in.nextInt();
        int j = in.nextInt();

        int bit_i = n & (1 << i);
        int bit_j = n & (1 << j);
        // swap
        n = (bit_i != 0) ? n | (1 << j) : n & ~(1 << j);
        n = (bit_j != 0) ? n | (1 << i) : n & ~(1 << i);

        out.println(n);
    }
}
