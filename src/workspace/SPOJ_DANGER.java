package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_DANGER {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        while(true) {
            String s = in.next();
            char []c = s.toCharArray();
            int a = c[0] - '0';
            int b = c[1] - '0';
            if(a == 0 && b == 0) return;
            int m = c[3] - '0';
            int n = (a * 10 + b) * (int)Math.pow(10, m);

            int ans = (n - powerOf2(n)) * 2 + 1;
            out.println(ans);
        }
    }

    int msb32(int x) {
        int msb = 0;
        int []val = {0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4};
        if((x & 0xFFFF0000) != 0) {
            msb += 16;
            x >>= 16;
        }
        if((x & 0x0000FF00) != 0) {
            msb += 8;
            x >>= 8;
        }
        if((x & 0x000000F0) != 0) {
            msb += 4;
            x >>= 4;
        }

        return msb + val[x] - 1;
    }

    int powerOf2(int x) {
        int i = 1;
        return i <<= msb32(x);
    }
}
