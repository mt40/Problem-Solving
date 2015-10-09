package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class ClosestNumberWithEqual1s {
    /**
     * Find the closest number with n that also have equal
     * number of 1s bit to n
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        // We swap the 1st 2 consecutive bits that are different
        for(int i = 0; i < 31; ++i) {
            int bit0 = n & (1 << i);
            int bit1 = n & (1 << (i + 1));
            boolean dif = true;
            if(bit0 * bit1 > 0 || (bit0 == 0 && bit1 == 0))
                dif = false;
            if(dif) {
                out.println(swapBit(n, i, i + 1));
                return;
            }
        }
    }

    int swapBit(int n, int i, int j) {
        int bit_i = n & (1 << i);
        int bit_j = n & (1 << j);
        //swap
        n = (bit_i != 0) ? n | (1 << j) : n & ~(1 << j);
        n = (bit_j != 0) ? n | (1 << i) : n & ~(1 << i);

        return n;
    }
}
