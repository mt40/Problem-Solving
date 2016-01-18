package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CodeStorm_2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        boolean b[] = new boolean[n];
        for(int i = 0; i < n; ++i)
            b[i] = in.nextInt() == 1;

        int ans = 0;
        for(int i = 0; i < n - 1; ++i) {
            if(b[i] || b[i + 1])
                continue;
            ans++;
            b[i + 1] = true;
        }

        out.println(ans);
    }
}
