package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SwapOddEvenBits {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int odd = n & 0xAAAAAAAA;
        int even = n & 0x55555555;
        int ans = (even << 1) | (odd >> 1);
        out.println(ans);
    }
}
