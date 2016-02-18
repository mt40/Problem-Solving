package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_327B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int start = 1000000;
        for(int i = start; i < start + n; ++i) {
            out.print(i + " ");
        }
        out.println();
    }
}
