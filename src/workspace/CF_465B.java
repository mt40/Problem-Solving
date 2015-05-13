package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_465B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int ans = 0, prev = 1, i = 0;
        while(i < n && a[i] != 1)
            i++;
        for(; i < n; ++i) {
            if(a[i] == 1) {
                if(prev == 1)
                    ans++;
                else
                    ans += 2;
            }
            prev = a[i];
        }

        out.println(ans);
    }
}
