package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_606A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();

        int a_r = a > x ? (a - x) / 2 : 0;
        int b_r = b > y ? (b - y) / 2 : 0;
        int c_r = c > z ? (c - z) / 2 : 0;
        int need = Math.max(0, x - a) + Math.max(0, y - b) + Math.max(0, z - c);
        if(a_r + b_r + c_r >= need)
            out.println("Yes");
        else
            out.println("No");
    }
}
