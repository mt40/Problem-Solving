package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_68A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int []p = new int[4];
        for(int i = 0; i < 4; ++i) {
            p[i] = in.nextInt();
        }

        int l = in.nextInt(), r = in.nextInt();

        int min = p[0];
        for(int pi : p) {
            min = Math.min(pi, min);
        }

        int count = 0;
        for(int i = l; i <= r; ++i) {
            count += (i < min) ? 1 : 0;
        }

        out.println(count);
    }
}
