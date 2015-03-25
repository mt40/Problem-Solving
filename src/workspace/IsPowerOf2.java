package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class IsPowerOf2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        boolean ans = (n & (n - 1)) == 0;
        if(ans)
            out.println("YES");
        else
            out.println("NO");
    }
}
