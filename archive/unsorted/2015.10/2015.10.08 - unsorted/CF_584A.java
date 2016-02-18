package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_584A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), t = in.nextInt();
        String ans = "" + t;

        while(ans.length() < n)
            ans += '0';

        if(n == 1 && t == 10)
            out.println(-1);
        else
            out.println(ans);
    }
}
