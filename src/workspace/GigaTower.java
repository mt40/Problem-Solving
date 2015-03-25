package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class GigaTower {
    int N;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        N = in.nextInt() + 1;
        int ans = 1;
        while(!String.valueOf(N).contains("8")) {
            N += 1;
            ans++;
        }
        out.println(ans);
    }
}
