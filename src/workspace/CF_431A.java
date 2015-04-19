package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_431A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int []a = new int[5];
        for(int i = 1; i <= 4; ++i)
            a[i] = in.nextInt();

        int ans = 0;
        char []b = in.next().toCharArray();
        int n = b.length;
        for(int i = 0; i < n; ++i)
            ans += a[b[i] - '0'];

        out.println(ans);
    }
}
