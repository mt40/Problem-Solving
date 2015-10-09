package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class ReverseBit {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = 0;

        for(int i = 0; i < 32; ++i) {
            int bit = n & (1 << i);
            if(bit != 0)
                k |= (1 << (31 - i));
        }

        out.println(String.format("%32s", Integer.toBinaryString(n)).replace(" ", "0"));
        out.println(String.format("%32s", Integer.toBinaryString(k)).replace(" ", "0"));
    }
}
