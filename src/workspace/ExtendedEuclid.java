package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class ExtendedEuclid {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt();
        EuclidExtend(a, b, out);
        out.println("0");
    }

    // calculate a.x + b.y = 1 (or modulo inverse)
    public int EuclidExtend(int a, int b, PrintWriter out) {
        int [][]st = new int[100][2];
        st[0][0] = 1; // s0 = 1
        st[1][0] = 0; // s1 = 0
        st[0][1] = 0; // t0 = 0
        st[1][1] = 1; // t1 = 1
        int i = 2, q = 1;
        while(q != 0 && b != 0) {
            q = a / b;
            int _a = a, _b = b;
            b = a % b;
            a = _b;
            st[i][0] = st[i - 2][0] - st[i - 1][0] * q; // cal s
            st[i][1] = st[i - 2][1] - st[i - 1][1] * q; // cal t

            out.format("%d = %d.%d + %d(r) s=%d t=%d\n",
                   _a, _b, q, b, st[i][0], st[i][1]);
            i++;
        }

        return 0;
    }
}
