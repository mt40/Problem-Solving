package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_493D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        if((n & 1) == 0) {
            out.println("white");
            out.println("1 2");
        }
        else {
            out.println("black");
        }
    }
}
