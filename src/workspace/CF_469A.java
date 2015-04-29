package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_469A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []rs = new int[n + 1];
        String []a = in.nextLine().split(" ");
        String []b = in.nextLine().split(" ");

        for(String c : a) {
            int x = Integer.valueOf(c);
            rs[x] = 1;
        }

        for(String c : b) {
            int x = Integer.valueOf(c);
            rs[x] = 1;
        }

        String ans = "I become the guy.";
        for(int i = 1; i <= n; ++i)
            if(rs[i] == 0)
                ans = "Oh, my keyboard!";
        out.println(ans);
    }
}
